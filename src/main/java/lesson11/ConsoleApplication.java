package lesson11;

import lesson11.http.Response;
import lesson11.service.UserService;
import lesson11.service.UserServiceImpl;

import java.lang.reflect.Method;

public class ConsoleApplication {
    public static void main(String[] args) throws Throwable {
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        UserService userService = new UserServiceImpl();
        Class<? extends UserService> clazz = userService.getClass();
        Method method = clazz.getMethod("findById", Long.class);


        Response response = exceptionHandler.invoke(userService, method, new Object[]{null});
        System.out.println(response);
    }
}
