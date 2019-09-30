package student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import student.repository.StudentRepository;
import student.repository.StudentRepositoryImpl;
import student.service.StudentService;
import student.service.StudentServiceImpl;
import student.service.UniversityService;
import student.service.UniversityServiceImpl;
import student.view.Validator;
import student.view.ValidatorImpl;

@Configuration
@ComponentScan(basePackages = "student")
public class AppConfig {

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    UniversityService universityService() {
        return new UniversityServiceImpl();
    }

    @Bean
    Validator validator() {
        return new ValidatorImpl();
    }
}
