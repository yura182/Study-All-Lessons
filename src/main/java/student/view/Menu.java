package student.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import student.domain.Faculty;
import student.domain.Student;
import student.service.StudentService;
import student.service.UniversityService;
import student.validator.StudentValidator;

import java.time.LocalDate;
import java.util.*;

@Component
public class Menu {
    private static final String LINE = "---------";
    private static final String LANGUAGE = LINE + "Choose your language" +  LINE
            + "\n1. English(default)\n2. Russian\n3.Your choose: ";
    private static final Scanner SCAN = new Scanner(System.in);

    private final StudentService studentService;
    private final UniversityService universityService;

    private ResourceBundle messages;
    private List<Student> students;

    @Autowired
    public Menu(StudentService studentService, UniversityService universityService) {
        this.studentService = studentService;
        this.universityService = universityService;
        Helper.createDemo(this.studentService);
    }

    public void run () {
        System.out.print(LANGUAGE);
        int input = SCAN.nextInt();

        if (input == 2) {
            setLocale("ru");
        } else {
            setLocale("en");
        }
    }

    private void mainMenu() {
        students = universityService.getAll();
        menu();
        int input = getInput(SCAN);

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
                facultyChoice(getInput(SCAN));
                break;
            case 3:
                System.out.println();
                System.out.println(LINE + messages.getString("type.in.year") + LINE);
                int year = getInput(SCAN);
                System.out.println();
                System.out.println(LINE + messages.getString("students.who.was.born") + " " + year + LINE);
                Helper.printHeader();
                universityService.getStudentsBornAfter(year).forEach(System.out::println);
                submenuMenu();
                break;
            case 4:
                List<String> data = new ArrayList<>();
                System.out.println();
                System.out.println(LINE + messages.getString("registration") + LINE);
                System.out.print(messages.getString("name") + " ");
                data.add(SCAN.next());
                System.out.print(messages.getString("surname") + " ");
                data.add(SCAN.next());
                System.out.print(messages.getString("date") + " ");
                data.add(SCAN.next());
                System.out.print(messages.getString("phone") + " ");
                data.add(SCAN.next());
                System.out.print("Email: ");
                data.add(SCAN.next());
                System.out.print(messages.getString("password") + " ");
                data.add(SCAN.next());

                studentService.register(Student.init()
                        .withName(data.get(0))
                        .withSurname(data.get(1))
                        .withBirthDate(LocalDate.parse(data.get(2)))
                        .withPhone(data.get(3))
                        .withEmail(data.get(4))
                        .withPassword(data.get(5)).build());
                System.out.println(messages.getString("student.registered"));
                submenuMenu();
                break;
            case 5:
                System.out.println();
                System.out.println(LINE + messages.getString("login.header") + LINE);
                System.out.print("Email: ");
                String email = SCAN.next();
                System.out.print(messages.getString("password") + " ");
                String password = (SCAN.next());
                Helper.printHeader();
                Student student = studentService.login(email, password);
                System.out.println(student);
                submenuMenu();
                break;
            default:
                exit();
        }
    }

    private void facultyChoice(int input) {
        switch (Faculty.values()[input-1]) {
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
    }

    private void facultyStudents(Faculty faculty) {
        System.out.println();
        System.out.println(LINE + messages.getString("students.of.faculty") + " " + faculty + LINE);
        Helper.printHeader();
        universityService.getFacultyStudents(faculty).forEach(System.out::println);
        submenuMenu();
    }

    private void submenuMenu() {
        System.out.println(messages.getString("back"));
        System.out.println(messages.getString("exit"));
        int input = getInput(SCAN);
        if (input == 1) {
            mainMenu();
        } else {
            exit();
        }
    }

    private int getInput(Scanner SCANner) {
        System.out.print(messages.getString("choose"));
        return SCANner.nextInt();
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
