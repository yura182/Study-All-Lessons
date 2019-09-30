package student;

import student.domain.Faculty;
import student.domain.Student;
import student.repository.StudentRepository;
import student.repository.StudentRepositoryImpl;
import student.service.CheckEmail;
import student.service.StudentService;
import student.service.StudentServiceImpl;

import java.time.LocalDate;
import java.util.*;

public class Menu {
    private ResourceBundle messages;
    private List<Student> students;
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private Scanner scan = new Scanner(System.in);
    private int input;

    {
        Helper.createDemo(studentRepository);
    }

    public void run () {
        System.out.println("---------Choose your language---------");
        System.out.println("1. English(default)");
        System.out.println("2. Russian");
        System.out.print("Your choose: ");
        input = scan.nextInt();

        if (input == 2) {
            Locale locale = new Locale("ru");
            messages = ResourceBundle.getBundle("Menu", locale);
            mainMenu();
        } else {
            Locale locale = new Locale("en");
            messages = ResourceBundle.getBundle("Menu", locale);
            mainMenu();
        }
    }

    private void mainMenu() {
        students = studentRepository.getAll();
        menu();
        input = getInput(scan);

        if (input < 0 || input > 5) {
            System.out.println(messages.getString("WRONG_INPUT"));
            mainMenu();
        } else if (input == 0) {
            exit();
        } else {
            subMenu(input);
        }
    }

    private void menu() {
        System.out.println(messages.getString("MENU"));
        System.out.println(messages.getString("SHOW_ALL"));
        System.out.println(messages.getString("SHOW_FACULTY"));
        System.out.println(messages.getString("SHOW_BORN_AFTER"));
        System.out.println(messages.getString("REGISTER"));
        System.out.println(messages.getString("LOGIN"));
        System.out.println(messages.getString("EXIT"));
    }

    private void subMenu(int input) {
        switch (input) {
            case 1:
                System.out.println(messages.getString("ALL_STUDENTS"));
                Helper.printHeader();
                students.forEach(student -> System.out.println(student));
                submenuMenu();
                break;
            case 2:
                System.out.println();
                System.out.println(messages.getString("ALL_FACULTIES"));
                System.out.println("1. " + Faculty.MATHEMATICS);
                System.out.println("2. " + Faculty.ELECTRONICS);
                System.out.println("3. " + Faculty.SOCIOLOGY);
                System.out.println("4. " + Faculty.LAW);
                System.out.println("0. Exit");
                this.input = getInput(scan);
                switch (this.input) {
                    case 1:
                        System.out.println();
                        System.out.println(messages.getString("STUDENTS_OF_FACULTY") + " " + Faculty.MATHEMATICS);
                        Helper.printHeader();
                        studentRepository.getFacultyStudents(Faculty.MATHEMATICS).forEach(student -> System.out.println(student));
                        submenuMenu();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println(messages.getString("STUDENTS_OF_FACULTY") + " "  + Faculty.ELECTRONICS);
                        Helper.printHeader();
                        studentRepository.getFacultyStudents(Faculty.ELECTRONICS).forEach(student -> System.out.println(student));
                        submenuMenu();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println(messages.getString("STUDENTS_OF_FACULTY") + " "  + Faculty.SOCIOLOGY);
                        Helper.printHeader();
                        studentRepository.getFacultyStudents(Faculty.SOCIOLOGY).forEach(student -> System.out.println(student));
                        submenuMenu();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println(messages.getString("STUDENTS_OF_FACULTY") + " "  + Faculty.LAW);
                        Helper.printHeader();
                        studentRepository.getFacultyStudents(Faculty.LAW).forEach(student -> System.out.println(student));
                        submenuMenu();
                        break;
                    default:
                        exit();
                }
                break;
            case 3:
                System.out.println();
                System.out.println(messages.getString("TYPE_IN_YEAR"));
                this.input = getInput(scan);
                System.out.println();
                System.out.println(messages.getString("STUDENTS_WHO_WAS_BORN") + " " + this.input + "---------");
                Helper.printHeader();
                studentRepository.getStudentsBornAfter(this.input).forEach(student -> System.out.println(student));
                submenuMenu();
                break;
            case 4:
                List<String> data = new ArrayList<>();
                System.out.println();
                System.out.println(messages.getString("REGISTRATION"));
                System.out.print(messages.getString("NAME") + " ");
                data.add(scan.next());
                System.out.print(messages.getString("SURNAME") + " ");
                data.add(scan.next());
                System.out.print(messages.getString("DATE") + " ");
                data.add(scan.next());
                System.out.print(messages.getString("PHONE") + " ");
                data.add(scan.next());

                while (true) {
                    System.out.print("Email: ");
                    String email = scan.next();
                    if (CheckEmail.checkCorrectness(email) && !CheckEmail.checkExistence(email, students)) {
                        data.add(email);
                        break;
                    }
                    System.out.println(messages.getString("EMAIL_NOT_CORRECT_AND_DONT_EXIST"));
                }

                StudentService studentService = new StudentServiceImpl(studentRepository);
                studentService.register(Student.init()
                        .withName(data.get(0))
                        .withSurname(data.get(1))
                        .withBirthDate(LocalDate.parse(data.get(2)))
                        .withPhone(data.get(3))
                        .withEmail(data.get(4)).build());
                System.out.println(messages.getString("STUDENT_REGISTERED"));
                submenuMenu();

                break;
            case 5:
                System.out.println();
                System.out.println(messages.getString("LOGIN_HEADER"));

                while (true) {
                    System.out.print("Email: ");
                    String email = scan.next();
                    if (CheckEmail.checkCorrectness(email)) {
                        if (CheckEmail.checkExistence(email, students)) {
                            for (Student student : students) {
                                if (email.equals(student.getEmail())) {
                                    System.out.println();
                                    System.out.println(messages.getString("ACCOUNT"));
                                    Helper.printHeader();
                                    System.out.println(student);
                                    break;
                                }
                            }
                            submenuMenu();
                        }
                        System.out.println(messages.getString("EMAIL_DONT_EXIST"));
                        mainMenu();
                    }
                    System.out.println(messages.getString("EMAIL_NOT_CORRECT"));
                }
            default:
                exit();
        }
    }

    private void submenuMenu() {
        System.out.println(messages.getString("BACK"));
        System.out.println(messages.getString("EXIT"));
        this.input = getInput(scan);
        if (input == 1) {
            mainMenu();
        } else {
            exit();
        }
    }

    private int getInput(Scanner scanner) {
        System.out.print(messages.getString("CHOOSE"));
        return scanner.nextInt();
    }

    private void exit() {
        System.out.println(messages.getString("BYE"));
        System.exit(0);
    }


}
