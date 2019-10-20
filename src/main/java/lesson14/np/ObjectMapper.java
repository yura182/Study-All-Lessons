package lesson14.np;

import lesson14.np.domain.Document;
import lesson14.np.domain.response.DocumentResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObjectMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm:ss");

    public Document map(DocumentResponse documentResponse) {
        Long number = Long.parseLong(documentResponse.getNumber());
        LocalDateTime dateTime = LocalDateTime.parse(documentResponse.getDateCreated(), FORMATTER);
        String citySender = documentResponse.getCitySender();
        String cityRecipient = documentResponse.getCityRecipient();
        return new Document(number, dateTime, citySender, cityRecipient);
    }
}
