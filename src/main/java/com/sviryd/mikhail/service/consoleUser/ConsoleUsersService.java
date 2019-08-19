package com.sviryd.mikhail.service.consoleUser;

import com.sviryd.mikhail.dao.console.IConsoleUsersDao;
import com.sviryd.mikhail.dao.console.impl.ConsoleUsersDao;
import com.sviryd.mikhail.dao.entity.User;

import java.util.List;

public class ConsoleUsersService implements IConsoleUsersService {
    private IConsoleUsersDao dao = new ConsoleUsersDao();

    @Override
    public void createTemporaryTable() {
        dao.createTemporaryTable();
    }

    @Override
    public void deleteTemporaryTable() {
        dao.deleteTemporaryTable();
    }

    @Override
    public boolean save(User user) {
        return dao.save(user);
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public User findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return dao.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return dao.findByLastName(lastName);
    }

    @Override
    public List<User> findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public List<User> findByRole(String role) {
        return dao.findByRole(role);
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber) {
        return dao.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Iterable<User> findAll() {
        return dao.findAll();
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public User delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean exists(int id) {
        return dao.exists(id);
    }
}
