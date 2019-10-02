package prototype;

import java.util.Objects;

public class Address implements Cloneable{
    private final String city;
    private final int code;

    public Address(String city, int code) {
        this.city = city;
        this.code = code;
    }

    public Address(Address prototype) {
        this.city = prototype.city;
        this.code = prototype.code;
    }

    @Override
    public Address clone() {
        return new Address(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return code == address.code &&
                city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, code);
    }
}
