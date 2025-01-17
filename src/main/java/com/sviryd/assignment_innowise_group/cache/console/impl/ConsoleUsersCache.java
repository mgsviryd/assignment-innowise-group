package com.sviryd.assignment_innowise_group.cache.console.impl;

import com.sviryd.assignment_innowise_group.cache.ConsoleCache;
import com.sviryd.assignment_innowise_group.cache.console.IConsoleUsersCache;
import com.sviryd.assignment_innowise_group.config.ConsoleConfig;
import com.sviryd.assignment_innowise_group.dao.entity.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleUsersCache implements IConsoleUsersCache {
    private static final String CONSOLE_USERS = ConsoleConfig.CONSOLE_USERS_CACHE;
    private static final String CONSOLE_USERS_ID = ConsoleConfig.CONSOLE_USERS_ID_CACHE;

    private Collection<User> getUsers() {
        final Collection<User> values = getUsersCache().values();
        if (values == null) return Collections.emptyList();
        return values;
    }

    private Map<Integer, User> getUsersCache() {
        return (Map<Integer, User>) ConsoleCache.get(CONSOLE_USERS);
    }

    private Integer increaseAndGetUsersId() {
        Integer id = (Integer) ConsoleCache.get(CONSOLE_USERS_ID);
        id += 1;
        ConsoleCache.put(CONSOLE_USERS_ID, id);
        return id;
    }

    private void resetUserId() {
        final Integer max = getUsersCache().keySet().stream().max(Comparator.naturalOrder()).orElseGet(() -> 0);
        ConsoleCache.put(CONSOLE_USERS_ID, max);
    }


    @Override
    public void createTemporaryTable() {
        if (ConsoleCache.get(CONSOLE_USERS) == null) {
            ConsoleCache.put(CONSOLE_USERS, new HashMap<Integer, User>());
        }
        if (ConsoleCache.get(CONSOLE_USERS_ID) == null) {
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
            if (!exists(user.getId())) {
                getUsersCache().put(user.getId(), user);
            }
        }
        resetUserId();
    }

    @Override
    public void uploadMergeIfPresent(List<User> users) {
        for (User user : users) {
            getUsersCache().put(user.getId(), user);
        }
        resetUserId();
    }

    @Override
    public void uploadRewrite(List<User> users) {
        deleteAll();
        for (User user : users) {
            getUsersCache().put(user.getId(), user);
        }
    }

    @Override
    public boolean save(User user) {
        user.setId(increaseAndGetUsersId());
        getUsersCache().put(user.getId(), user);
        return true;
    }

    @Override
    public User update(User user) {
        return getUsersCache().put(user.getId(), user);
    }

    @Override
    public User findOne(int id) {
        return getUsersCache().get(id);
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
        return getUsersCache().size();
    }

    @Override
    public User delete(int id) {
        return getUsersCache().remove(id);
    }

    @Override
    public void deleteAll() {
        getUsersCache().clear();
    }

    @Override
    public boolean exists(int id) {
        return getUsersCache().containsKey(id);
    }
}
