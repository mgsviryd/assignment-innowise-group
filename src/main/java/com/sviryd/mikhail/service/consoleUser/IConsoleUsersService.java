package com.sviryd.mikhail.service.consoleUser;

import com.sviryd.mikhail.dao.entity.User;

import java.util.List;

public interface IConsoleUsersService {
    void createTemporaryTable();
    void deleteTemporaryTable();
    boolean save(User user);
    User update(int id, User user);
    User findOne(int id);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByPhoneNumber(String phoneNumber);
    Iterable<User> findAll();
    int count();
    User delete(int id);
    boolean exists(int id);
}
