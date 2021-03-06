package lesson14.np;

import lesson14.np.domain.Document;
import lesson14.np.domain.response.DocumentResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        PostRequest postRequest = new PostRequest(new URL("https://api.novaposhta.ua/v2.0/json/"));
        DocumentFinder documentFinder = new DocumentFinder(postRequest);
        LocalDate date = LocalDate.of(2019, 10, 15);
        ObjectMapper objectMapper = new ObjectMapper();
        Json<List<Document>> json = new Json<>();

        long firstNumberOfTheDay = documentFinder.findFirstNumberOfTheDay(date, 59000454875954L);
        System.out.println(firstNumberOfTheDay);


        Instant start = Instant.now();
        List<DocumentResponse> documentsOfDay = documentFinder
                .parseDocumentsOfTheDay(date.plusDays(1L), firstNumberOfTheDay);

        int counter = 1;
        int parcels = 0;
        long lastParsedNumber = 0;

        while (!documentsOfDay.isEmpty()) {
            List<Document> documents = documentsOfDay.stream().map(objectMapper::map).collect(Collectors.toList());
            String documentsJson = json.toJson(documents);
            String filePrefix = String.valueOf(firstNumberOfTheDay).substring(0, 4);
            String allDocumentsFile = "./src/main/java/lesson14/np/stat/json/"
                    + date.toString() + "_" + filePrefix + "_" + counter + ".json";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(allDocumentsFile))) {
                writer.write(documentsJson);
            } catch (IOException e) {
                e.printStackTrace();
            }

            parcels += documentsOfDay.size();

            lastParsedNumber = Long.parseLong(documentsOfDay.get(documentsOfDay.size() - 1).getNumber());
            documentsOfDay = documentFinder.parseDocumentsOfTheDay(date.plusDays(1L), lastParsedNumber + 1);

            counter += 1;
            if (counter % 50 == 0) {
                System.out.println(counter);
            }

        }

        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);

        String statisticFile = "./src/main/java/lesson14/np/stat/statistic.txt";
        StringBuilder statistic = getStatistic(date, duration, lastParsedNumber, firstNumberOfTheDay, parcels);

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(statisticFile, true)))) {
            printWriter.println(statistic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getStatistic(LocalDate date, Duration duration, long lastNumberOfTheDay,
                                              long firstNumberOfTheDay, int size) {
        return new StringBuilder()
                .append(date.toString())
                .append(" - ")
                .append(size)
                .append(" parcels")
                .append(", first number: ")
                .append(firstNumberOfTheDay)
                .append(", last number: ")
                .append(lastNumberOfTheDay)
                .append(", time: ")
                .append(duration.toMinutes())
                .append(" minutes");
    }
}
