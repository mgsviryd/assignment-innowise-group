package com.sviryd.mikhail.cache.console.impl;

import com.sviryd.mikhail.cache.ConsoleCache;
import com.sviryd.mikhail.cache.console.IConsoleUsersCache;
import com.sviryd.mikhail.config.ConsoleConfig;
import com.sviryd.mikhail.dao.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUsersCache implements IConsoleUsersCache {
    private static final String CONSOLE_USERS = ConsoleConfig.CONSOLE_USERS_CACHE;
    private static final String CONSOLE_USERS_ID = ConsoleConfig.CONSOLE_USERS_ID_CACHE;

    private List<User> getUsers() {
        return (List<User>) ConsoleCache.get(CONSOLE_USERS);
    }

    private Integer increaseAndGetUsersId() {
        Integer id = (Integer) ConsoleCache.get(CONSOLE_USERS_ID);
        id += 1;
        ConsoleCache.put(CONSOLE_USERS_ID, id);
        return id;
    }

    private void resetUserId() {
        final Integer max = getUsers().stream().map(User::getId).max(Math::max).orElseGet(() -> 0);
        ConsoleCache.put(CONSOLE_USERS_ID, max);
    }


    @Override
    public void createTemporaryTable() {
        if (getUsers() == null) {
            ConsoleCache.put(CONSOLE_USERS, new ArrayList<User>());
            ConsoleCache.put(CONSOLE_USERS_ID, 0);
        }
    }

    @Override
    public void deleteTemporaryTable() {
        ConsoleCache.remove(CONSOLE_USERS);
        ConsoleCache.remove(CONSOLE_USERS_ID);
    }

    @Override
    public void uploadMergeIfAbsent(List<User> users) {
        for (User user : users) {
            final User absent = findOne(user.getId());
            if (absent == null) {
                save(user);
            }
        }
        resetUserId();
    }

    @Override
    public void uploadMergeIfPresent(List<User> users) {
        for (User user : users) {
            final User present = findOne(user.getId());
            if (present != null){
                delete(present.getId());
            }
            save(user);
        }
        resetUserId();
    }

    @Override
    public void uploadRewrite(List<User> users) {
        deleteAll();
        for (User user : users) {
            save(user);
        }
    }

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
        return getUsers().stream().filter(x -> x.getId().equals(id)).findFirst().orElseGet(() -> null);
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
    public void deleteAll() {
        getUsers().clear();
    }

    @Override
    public boolean exists(int id) {
        final User user = findOne(id);
        return user != null;
    }
}
