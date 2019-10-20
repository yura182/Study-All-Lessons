package lesson14.np.domain;

import java.time.LocalDateTime;

public class Document {
    private final Long number;
    private final LocalDateTime dateTime;
    private final String citySender;
    private final String cityRecipient;

    public Document(Long number, LocalDateTime dateTime, String citySender, String cityRecipient) {
        this.number = number;
        this.dateTime = dateTime;
        this.citySender = citySender;
        this.cityRecipient = cityRecipient;
    }
}
