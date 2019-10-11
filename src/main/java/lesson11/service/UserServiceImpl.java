package lesson11.service;

import lesson11.domain.User;
import lesson11.exception.EntityNotFoundRuntimeException;
import lesson11.exception.IllegalArgumentRuntimeException;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentRuntimeException();
        }

        if (id == 1) {
            return new User();
        }

        throw new EntityNotFoundRuntimeException();
    }
}
