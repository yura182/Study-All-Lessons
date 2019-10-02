package student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import student.config.AppConfig;
import student.view.Menu;

public class ConsoleApplication {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        appContext.getBean(Menu.class).run();
    }
}
