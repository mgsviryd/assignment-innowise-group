package com.sviryd.mikhail.service.console.user.dao;

import com.sviryd.mikhail.dao.entity.User;

import java.util.List;

public interface IConsoleUsersService {
    void createTemporaryTable();
    void deleteTemporaryTable();
    boolean save(User user);
    User update(User user);
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
