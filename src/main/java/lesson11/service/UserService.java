package lesson11.service;

import lesson11.domain.User;

public interface UserService {
    User findById(Long id);
}
