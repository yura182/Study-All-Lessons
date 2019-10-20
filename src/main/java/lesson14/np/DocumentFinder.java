package lesson14.np;

import com.google.gson.Gson;
import lesson14.np.domain.request.DocumentRequest;
import lesson14.np.domain.request.Properties;
import lesson14.np.domain.request.Request;
import lesson14.np.domain.response.DocumentResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DocumentFinder {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm:ss");

    private final PostRequest postRequest;

    public DocumentFinder(PostRequest postRequest) {
        this.postRequest = postRequest;
    }

    public Long findFirstNumberOfTheDay(LocalDate date, long initialNumber) throws IOException {
        DocumentResponse[] documents = makeRequest(initialNumber);
        Long number = getFirstNumberOfDay(date, documents);

        while (number == null) {
            long nextNumber = Long.parseLong(documents[documents.length - 1].getNumber());
            documents = makeRequest(nextNumber);
            number = getFirstNumberOfDay(date, documents);
        }

        return number;
    }

    public List<DocumentResponse> parseDocumentsOfTheDay(LocalDate nextDay, long firstNumber) throws IOException {
        LocalDate thisDay = nextDay.minusDays(1L);
        List<DocumentResponse> result = new ArrayList<>(100);
        DocumentResponse[] documents = makeRequest(firstNumber);

        if (isThisDay(documents, thisDay)) {
            Arrays.stream(documents)
                    .filter(d -> Objects.nonNull(d.getDateCreated()))
                    .filter(d->LocalDate.parse(d.getDateCreated(), FORMATTER).equals(thisDay))
                    .forEach(result::add);
        }

        return result;
    }

    private boolean isThisDay(DocumentResponse[] documents, LocalDate day) {
        Optional<DocumentResponse> result = Arrays.stream(documents)
                .filter(d -> Objects.nonNull(d.getDateCreated()))
                .filter(d -> LocalDate.parse(d.getDateCreated(), FORMATTER).equals(day))
                .findFirst();
        return result.isPresent();
    }

    private DocumentResponse[] makeRequest(long initialNumber) throws IOException {
        Gson gson = new Gson();
        String arrayRequest = generateRequest(initialNumber);

        String response = postRequest.request(arrayRequest);
        DocumentResponse[] documents = gson.fromJson(response, DocumentResponse[].class);
        return documents;
    }

    private Long getFirstNumberOfDay(LocalDate date, DocumentResponse[] documents) {
        for (DocumentResponse document : documents) {
            if (document.getDateCreated() == null) {
                continue;
            }
            LocalDate dateOfDocument = LocalDate.parse(document.getDateCreated(), FORMATTER);
            if (dateOfDocument.equals(date)) {
                return Long.parseLong(document.getNumber());
            }
        }
        return null;
    }

    private String generateRequest(long number) {
        Gson gson = new Gson();
        List<DocumentRequest> documentRequests = new DocumentsGenerator().generate(number);
        Properties properties = new Properties(documentRequests);
        Request request = new Request("TrackingDocument", "getStatusDocuments", properties);
        return gson.toJson(request);
    }
}
