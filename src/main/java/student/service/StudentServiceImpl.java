package student.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.domain.Student;
import student.encoder.PasswordEncoder;
import student.exception.NoSuchUserException;
import student.exception.PasswordGenerationException;
import student.exception.PasswordNotMatchException;
import student.repository.StudentRepository;
import student.validator.StudentValidator;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentValidator studentValidator, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Student register(Student student) {
        studentValidator.isNull(student);

        studentValidator.validate(student);

        String encodePassword = passwordEncoder.encode(student.getPassword())
                .orElseThrow(() -> new PasswordGenerationException("Password hash generation failed"));
        Student studentWithEncodedPass = new Student(student, encodePassword);
        LOGGER.info("User registered");
        return studentRepository.save(studentWithEncodedPass);
    }

    @Override
    public Student login(String email, String password) {
        studentValidator.isNull(email, password);
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchUserException("User not found"));
        boolean passwordMatch = passwordEncoder.verifyPassword(password, student.getPassword());

        if (!passwordMatch) {
            LOGGER.warn("Incorrect Password");
            throw new PasswordNotMatchException("Password is incorrect");
        }
        LOGGER.info("User logged in");
        return student;
    }
}
