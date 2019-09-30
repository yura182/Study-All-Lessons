package student.domain;

import java.util.Objects;

public class Address {
    private final String zipCode;
    private final String country;
    private final String city;
    private final String street;
    private final String houseNumber;

    private Address(Builder builder) {
        this.zipCode = builder.zipCode;
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.houseNumber = builder.houseNumber;
    }

    public static Builder init() {
        return new Builder();
    }

    public static class Builder {
        private String zipCode;
        private String country;
        private String city;
        private String street;
        private String houseNumber;

        private Builder() {

        }

        public Builder withCode(String code) {
            this.zipCode = code;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouse(String house) {
            this.houseNumber = house;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(Objects.nonNull(this.zipCode) ? this.zipCode + " " : "");
        out.append(Objects.nonNull(this.country) ? this.country + " " : "");
        out.append(Objects.nonNull(this.city) ? this.city + " " : "");
        out.append(Objects.nonNull(this.street) ? this.street + " " : "");
        out.append(Objects.nonNull(this.houseNumber) ? this.houseNumber : "");
        return out.toString();
    }
}
