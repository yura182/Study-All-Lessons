package prototype;

import java.util.Objects;

public class User implements Cloneable {
    private final Address address;
    private final String name;
    private final String surname;

    public User(Address address, String name, String surname) {
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    public User (User prototype) throws CloneNotSupportedException {
        this.name = prototype.name;
        this.surname = prototype.surname;
        this.address = prototype.address.clone();
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        super.clone();
        return new User(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return address.equals(user.address) &&
                name.equals(user.name) &&
                surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, surname);
    }
}
