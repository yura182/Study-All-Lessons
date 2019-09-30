package student.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import student.config.AppConfig;
import student.domain.Faculty;
import student.domain.Student;
import student.repository.StudentRepository;
import student.service.StudentService;
import student.service.UniversityService;

import java.time.LocalDate;
import java.util.*;

public class Menu {
    private static final String LINE = "---------";
    private static final String LANGUAGE = LINE + "Choose your language" +  LINE
            + "\n1. English(default)\n2. Russian\n3.Your choose: ";
    private final ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    private final StudentRepository studentRepository = appContext.getBean(StudentRepository.class);
    private final StudentService studentService = appContext.getBean(StudentService.class);
    private final UniversityService universityService = appContext.getBean(UniversityService.class);
    private final Validator validator = appContext.getBean(Validator.class);
    private final Scanner scan = new Scanner(System.in);
    private ResourceBundle messages;
    private List<Student> students;
    private int input;

    public Menu() {
        Helper.createDemo(studentService);
    }

    public void run () {
        System.out.print(LANGUAGE);
        input = scan.nextInt();

        if (input == 2) {
            setLocale("ru");
        } else {
            setLocale("en");
        }
    }

    private void mainMenu() {
        students = studentRepository.getAll();
        menu();
        input = getInput(scan);

        if (input < 0 || input > 5) {
            System.out.println(messages.getString("wrong.input"));
            mainMenu();
        } else if (input == 0) {
            exit();
        } else {
            subMenu(input);
        }
    }

    private void menu() {
        System.out.println(LINE + messages.getString("menu") + LINE);
        System.out.println(messages.getString("show.all"));
        System.out.println(messages.getString("show.faculty"));
        System.out.println(messages.getString("show.born.after"));
        System.out.println(messages.getString("register"));
        System.out.println(messages.getString("login"));
        System.out.println(messages.getString("exit"));
    }

    private void subMenu(int input) {
        switch (input) {
            case 1:
                System.out.println(LINE + messages.getString("all.students") + LINE);
                Helper.printHeader();
                students.forEach(System.out::println);
                submenuMenu();
                break;
            case 2:
                System.out.println();
                System.out.println(LINE + messages.getString("all.faculties") + LINE);
                System.out.println("1. " + Faculty.MATHEMATICS);
                System.out.println("2. " + Faculty.ELECTRONICS);
                System.out.println("3. " + Faculty.SOCIOLOGY);
                System.out.println("4. " + Faculty.LAW);
                System.out.println("0. Exit");
                this.input = getInput(scan);
                switch (Faculty.values()[this.input-1]) {
                    case MATHEMATICS:
                        facultyStudents(Faculty.MATHEMATICS);
                        break;
                    case ELECTRONICS:
                        facultyStudents(Faculty.ELECTRONICS);
                        break;
                    case SOCIOLOGY:
                        facultyStudents(Faculty.SOCIOLOGY);
                        break;
                    case LAW:
                        facultyStudents(Faculty.LAW);
                        break;
                    default:
                        exit();
                }
                break;
            case 3:
                System.out.println();
                System.out.println(LINE + messages.getString("type.in.year") + LINE);
                this.input = getInput(scan);
                System.out.println();
                System.out.println(LINE + messages.getString("students.who.was.born") + " " + this.input + LINE);
                Helper.printHeader();
                universityService.getStudentsBornAfter(this.input).forEach(System.out::println);
                submenuMenu();
                break;
            case 4:
                List<String> data = new ArrayList<>();
                System.out.println();
                System.out.println(LINE + messages.getString("registration") + LINE);
                while (true) {
                    System.out.print(messages.getString("name") + " ");
                    String name = scan.next();
                    if (validator.checkName(name)) {
                        data.add(name);
                        break;
                    }
                    System.out.println(messages.getString("name.validate"));
                }
                while (true) {
                    System.out.print(messages.getString("surname") + " ");
                    String surname = scan.next();
                    if (validator.checkName(surname)) {
                        data.add(surname);
                        break;
                    }
                    System.out.println(messages.getString("surname.validate"));
                }
                System.out.print(messages.getString("date") + " ");
                data.add(scan.next());
                System.out.print(messages.getString("phone") + " ");
                data.add(scan.next());
                while (true) {
                    System.out.print("Email: ");
                    String email = scan.next();
                    if (validator.checkEmailCorrectness(email) && !validator.checkEmailExistence(email, students)) {
                        data.add(email);
                        break;
                    }
                    System.out.println(messages.getString("email.not.correct.and.dont.exist"));
                }

                studentService.register(Student.init()
                        .withName(data.get(0))
                        .withSurname(data.get(1))
                        .withBirthDate(LocalDate.parse(data.get(2)))
                        .withPhone(data.get(3))
                        .withEmail(data.get(4)).build());
                System.out.println(messages.getString("student.registered"));
                submenuMenu();

                break;
            case 5:
                System.out.println();
                System.out.println(LINE + messages.getString("login.header") + LINE);

                while (true) {
                    System.out.print("Email: ");
                    String email = scan.next();
                    if (validator.checkEmailCorrectness(email)) {
                        if (validator.checkEmailExistence(email, students)) {
                            for (Student student : students) {
                                if (email.equals(student.getEmail())) {
                                    System.out.println();
                                    System.out.println(LINE + messages.getString("account") + LINE);
                                    Helper.printHeader();
                                    System.out.println(student);
                                    break;
                                }
                            }
                            submenuMenu();
                        }
                        System.out.println(messages.getString("email.dont.exist"));
                        mainMenu();
                    }
                    System.out.println(messages.getString("email.not.correct"));
                }
            default:
                exit();
        }
    }

    private void facultyStudents(Faculty faculty) {
        System.out.println();
        System.out.println(LINE + messages.getString("students.of.faculty") + " " + faculty + LINE);
        Helper.printHeader();
        universityService.getFacultyStudents(faculty).forEach(student -> System.out.println(student));
        submenuMenu();
    }

    private void submenuMenu() {
        System.out.println(messages.getString("back"));
        System.out.println(messages.getString("exit"));
        this.input = getInput(scan);
        if (input == 1) {
            mainMenu();
        } else {
            exit();
        }
    }

    private int getInput(Scanner scanner) {
        System.out.print(messages.getString("choose"));
        return scanner.nextInt();
    }

    private void setLocale(String ru) {
        Locale locale = new Locale(ru);
        messages = ResourceBundle.getBundle("Menu", locale);
        mainMenu();
    }

    private void exit() {
        System.out.println(messages.getString("bye"));
        System.exit(0);
    }


}
