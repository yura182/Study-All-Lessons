package student.view;

import student.domain.*;
import student.repository.StudentRepository;
import student.service.StudentService;
import student.service.StudentServiceImpl;

import java.time.LocalDate;


public class Helper {
    public static void createDemo(StudentService studentService) {

        studentService.register((Student.init().withName("Yuriy").withMiddleName("Aleksandrovich").withSurname("Petrashenko")
                .withBirthDate(LocalDate.of(1998, 4, 11))
                .withAddress(Address.init()
                        .withCode("02232")
                        .withCountry("Ukraine")
                        .withCity("Kyiv")
                        .withStreet("Gagarina")
                        .withHouse("12v")
                        .build()).withPhone("066-400-36-26")
                .withFaculty(Faculty.ELECTRONICS).withLevel(Level.FIFTH).withGroup(Group.E5)
                .withEmail("user1@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Dmitriy").withMiddleName("Vladimirovich").withSurname("Glushko")
                .withBirthDate(LocalDate.of(1999, 12, 1))
                .withAddress(Address.init()
                        .withCode("02234")
                        .withCountry("Ukraine")
                        .withCity("Kharkiv")
                        .withStreet("Shevchenko")
                        .withHouse("15")
                        .build()).withPhone("095-203-38-20")
                .withFaculty(Faculty.MATHEMATICS).withLevel(Level.FIRST).withGroup(Group.M1)
                .withEmail("user2@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Olga").withSurname("Orlova")
                .withBirthDate(LocalDate.of(1997, 6, 30))
                .withAddress(Address.init()
                        .withCode("02200")
                        .withCountry("Ukraine")
                        .withCity("Dnipro")
                        .withStreet("Vasulenka")
                        .withHouse("22a")
                        .build()).withPhone("067-000-12-32")
                .withFaculty(Faculty.LAW).withLevel(Level.SECOND).withGroup(Group.L2)
                .withEmail("user3@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Tamara").withMiddleName("Vladimirovna").withSurname("Vasilevnko")
                .withBirthDate(LocalDate.of(1996, 9, 10))
                .withAddress(Address.init()
                        .withCode("02201")
                        .withCountry("Ukraine")
                        .withCity("Kyiv")
                        .withStreet("Balzaka")
                        .withHouse("122")
                        .build()).withPhone("067-122-16-55")
                .withFaculty(Faculty.MATHEMATICS).withLevel(Level.THIRD).withGroup(Group.M3)
                .withEmail("user4@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Anatoliy").withMiddleName("Olegovich").withSurname("Pushkin")
                .withBirthDate(LocalDate.of(1995, 10, 1))
                .withAddress(Address.init()
                        .withCode("02222")
                        .withCountry("Ukraine")
                        .withCity("Lviv")
                        .withStreet("Grinchenka")
                        .withHouse("5b")
                        .build()).withPhone("095-203-16-11")
                .withFaculty(Faculty.ELECTRONICS).withLevel(Level.FOURTH).withGroup(Group.E4)
                .withEmail("user5@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Tetyana").withMiddleName("Sergiivna").withSurname("Zinchenko")
                .withBirthDate(LocalDate.of(1995, 3, 15))
                .withAddress(Address.init()
                        .withCode("02225")
                        .withCountry("Ukraine")
                        .withCity("Odesa")
                        .withStreet("Primorska")
                        .withHouse("17")
                        .build()).withPhone("066-300-10-12")
                .withFaculty(Faculty.LAW).withLevel(Level.FIFTH).withGroup(Group.L5)
                .withEmail("user6@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Valeriy").withSurname("Shevchenko")
                .withBirthDate(LocalDate.of(1998, 1, 10))
                .withAddress(Address.init()
                        .withCode("02225")
                        .withCountry("Ukraine")
                        .withCity("Kiyv")
                        .withStreet("Khreshatyk")
                        .withHouse("10")
                        .build()).withPhone("099-555-12-76")
                .withFaculty(Faculty.MATHEMATICS).withLevel(Level.FIRST).withGroup(Group.M1)
                .withEmail("user7@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Vadim").withSurname("Kycherenko")
                .withBirthDate(LocalDate.of(1997, 2, 18))
                .withAddress(Address.init()
                        .withCode("02225")
                        .withCountry("Ukraine")
                        .withCity("Kiyv")
                        .withStreet("Politechnichna")
                        .withHouse("8")
                        .build()).withPhone("067-985-12-89")
                .withFaculty(Faculty.MATHEMATICS).withLevel(Level.FIRST).withGroup(Group.M1)
                .withEmail("user8@gmail.com").withPassword("222333444")
                .build()));

        studentService.register((Student.init().withName("Vlad").withSurname("Kycherenko")
                .withBirthDate(LocalDate.of(1995, 2, 18))
                .withAddress(Address.init()
                        .withCode("02225")
                        .withCountry("Ukraine")
                        .withCity("Kiyv")
                        .withStreet("Politechnichna")
                        .withHouse("8")
                        .build()).withPhone("067-985-12-90")
                .withFaculty(Faculty.SOCIOLOGY).withLevel(Level.FIRST).withGroup(Group.S1)
                .withEmail("user9@gmail.com").withPassword("222333444")
                .build()));
    }


    public static void printHeader() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("| %-2s |", "ID"));
        out.append(String.format(" %-15s|", "SURNAME"));
        out.append(String.format(" %-10s|", "NAME"));
        out.append(String.format(" %-15s|", "MIDDLE NAME"));
        out.append(String.format(" %-11s|", "BIRTH DATE"));
        out.append(String.format(" %-38s|", "ADDRESS"));
        out.append(String.format(" %-14s|", "PHONE NUMBER"));
        out.append(String.format(" %-12s|", "FACULTY"));
        out.append(String.format(" %-7s|", "YEAR"));
        out.append(String.format(" %-5s |", "GROUP"));
        out.append(String.format(" %-20s |", "EMAIL"));
        System.out.println(out.toString());
    }
}
