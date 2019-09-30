package student.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private static Long nextId = 1L;

    private final Long id;
    private final String name;
    private final String middleName;
    private final String surname;
    private final LocalDate birthDate;
    private final Address address;
    private final String phoneNumber;
    private final Faculty faculty;
    private final Level level;
    private final Group group;
    private final String email;

    private Student(Builder builder) {
        this.id = nextId++;
        this.name = builder.name;
        this.middleName = builder.middleName;
        this.surname = builder.surname;
        this.birthDate = builder.birthDate;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.faculty = builder.faculty;
        this.level = builder.level;
        this.group = builder.group;
        this.email = builder.email;
    }

    public Student(Student student, String phoneNumber) {
        this.id = student.id;
        this.name = student.name;
        this.middleName = student.middleName;
        this.surname = student.surname;
        this.birthDate = student.birthDate;
        this.address = student.address;
        this.phoneNumber = phoneNumber;
        this.faculty = student.faculty;
        this.level = student.level;
        this.group = student.group;
        this.email = student.email;
    }

    public static Builder init() {
        return new Builder();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Level getLevel() {
        return level;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Group getGroup() {
        return group;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String name;
        private String middleName;
        private String surname;
        private LocalDate birthDate;
        private Address address;
        private String phoneNumber;
        private Faculty faculty;
        private Level level;
        private Group group;
        private String email;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBirthDate(LocalDate date) {
            this.birthDate = date;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phoneNumber = phone;
            return this;
        }

        public Builder withFaculty(Faculty faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder withLevel(Level level) {
            this.level = level;
            return this;
        }

        public Builder withGroup(Group group) {
            this.group = group;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }



    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("| %-2s |", this.id));
        out.append(String.format(" %-15s|", Objects.toString(this.surname, "")));
        out.append(String.format(" %-10s|", Objects.toString(this.name, "")));
        out.append(String.format(" %-15s|", Objects.toString(this.middleName, "")));
        out.append(String.format(" %-11s|", Objects.toString(this.birthDate, "")));
        out.append(String.format(" %-38s|", Objects.toString(this.address, "")));
        out.append(String.format(" %-14s|", Objects.toString(this.phoneNumber, "")));
        out.append(String.format(" %-12s|", Objects.toString(this.faculty, "")));
        out.append(String.format(" %-7s|", Objects.toString(this.level, "")));
        out.append(String.format(" %-5s |", Objects.toString(this.group, "")));
        out.append(String.format(" %-20s |", Objects.toString(this.email, "")));

        return out.toString();
    }
}
