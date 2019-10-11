package lesson11;

import lesson11.exception.EntityNotFoundRuntimeException;
import lesson11.exception.IllegalArgumentRuntimeException;
import lesson11.http.Response;
import lesson11.http.Status;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static lesson11.http.Status.*;

public class ExceptionHandler implements InvocationHandler {

    private Map<Class<? extends Exception>, Status> exceptionToStatus = new HashMap<>();

    public ExceptionHandler() {
        exceptionToStatus.put(EntityNotFoundRuntimeException.class, NOT_FOUND);
        exceptionToStatus.put(IllegalArgumentRuntimeException.class, SERVER_ERROR);
    }

    @Override
    public Response invoke(Object proxy, Method method, Object[] args){
        try {
            Object invoke = method.invoke(proxy, args);
            return new Response(OK, invoke.toString());
        } catch (Exception e) {
            Class<? extends Throwable> clazz = e.getCause().getClass();
            Status status = exceptionToStatus.get(clazz);
            return new Response(status, "");
        }
    }
}