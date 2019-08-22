package com.sviryd.mikhail.console.dao.user;

import com.sviryd.mikhail.console.dao.entity.User;

import java.util.List;

public interface IUserDao {
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
    void deleteAll();
    boolean exists(int id);
}
