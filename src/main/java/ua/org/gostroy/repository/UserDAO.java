package ua.org.gostroy.repository;

import ua.org.gostroy.entity.User;

import java.util.List;


public interface UserDAO {
    User find(Long id);
    List<User> findAll();
    Long save(User user);
    void update(User user);
}
