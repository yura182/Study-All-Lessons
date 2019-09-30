package student.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import student.domain.Student;
import student.repository.StudentRepository;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void shouldReturnRegisteredStudent() {
        Student student = Student.init().build();
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Assert.assertNotNull(studentService.register(student));
    }

    @Test
    public void shouldReturnChangedStudent() {
        Student student = Student.init().build();
        Student studentChanged = Student.init().withPhone("000-00-00-00").build();
        when(studentRepository.update(any(Student.class))).thenReturn(studentChanged);

        Assert.assertEquals(studentService.changePhone(student, "000-00-00-00"), studentChanged);
    }
}