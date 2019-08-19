package com.sviryd.mikhail.dao.console.impl;

import com.sviryd.mikhail.dao.hash.ConsoleHash;
import com.sviryd.mikhail.dao.console.IConsoleUsersDao;
import com.sviryd.mikhail.dao.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUsersDao implements IConsoleUsersDao {
    private static final String CONSOLE_USERS = "CONSOLE_USERS";
    private static final String CONSOLE_USERS_ID = "CONSOLE_USERS_ID";

    private List<User> getUsers() {
        return (List<User>) ConsoleHash.get(CONSOLE_USERS);
    }

    private Integer increaseAndGetUsersId() {
        return (Integer) ConsoleHash.get(CONSOLE_USERS_ID);
    }
    @Override
    public void createTemporaryTable() {
        if (getUsers() == null) {
            ConsoleHash.put(CONSOLE_USERS, new ArrayList<User>());
            ConsoleHash.put(CONSOLE_USERS_ID, 0);
        }
    }
    @Override
    public void deleteTemporaryTable() {
        ConsoleHash.remove(CONSOLE_USERS);
        ConsoleHash.remove(CONSOLE_USERS_ID);}
    @Override
    public boolean save(User user) {
        user.setId(increaseAndGetUsersId());
        return getUsers().add(user);
    }

    @Override
    public User update(User user) {
        User one = findOne(user.getId());
        int i = getUsers().indexOf(one);
        return getUsers().set(i, user);
    }

    @Override
    public User findOne(int id) {
        return getUsers().stream().filter(x->x.getId().equals(id)).findFirst().orElseGet(()->null);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return getUsers().stream().filter(x -> x.getFirstName().equals(firstName)).collect(Collectors.toList());
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return getUsers().stream().filter(x -> x.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<User> findByEmail(String email) {
        return getUsers().stream().filter(x -> x.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<User> findByRole(String role) {
        return getUsers().stream().filter(x -> x.getRoles().contains(role)).collect(Collectors.toList());
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber) {
        return getUsers().stream().filter(x -> x.getPhoneNumbers().contains(phoneNumber)).collect(Collectors.toList());
    }

    @Override
    public Iterable<User> findAll() {
        return getUsers();
    }

    @Override
    public int count() {
        return getUsers().size();
    }

    @Override
    public User delete(int id) {
        return getUsers().remove(id);
    }

    @Override
    public boolean exists(int id) {
        final User user = findOne(id);
        return user != null;
    }
}
