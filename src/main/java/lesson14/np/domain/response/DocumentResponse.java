package lesson14.np.domain.response;

public class DocumentResponse {
    private final String Number;
    private final String DateCreated;
    private final String CitySender;
    private final String CityRecipient;

    public DocumentResponse(String number, String dateCreated, String citySender, String cityRecipient) {
        Number = number;
        DateCreated = dateCreated;
        CitySender = citySender;
        CityRecipient = cityRecipient;
    }

    public String getNumber() {
        return Number;
    }

    public String getCitySender() {
        return CitySender;
    }

    public String getCityRecipient() {
        return CityRecipient;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    @Override
    public String toString() {
        return "DocumentResponse{" +
                "Number='" + Number + '\'' +
                ", DateCreated='" + DateCreated + '\'' +
                ", CitySender='" + CitySender + '\'' +
                ", CityRecipient='" + CityRecipient + '\'' +
                '}';
    }
}
