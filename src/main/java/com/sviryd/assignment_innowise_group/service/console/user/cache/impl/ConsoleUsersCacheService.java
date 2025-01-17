package com.sviryd.assignment_innowise_group.service.console.user.cache.impl;

import com.sviryd.assignment_innowise_group.cache.console.IConsoleUsersCache;
import com.sviryd.assignment_innowise_group.cache.console.impl.ConsoleUsersCache;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUsersCacheService;

import java.util.List;

public class ConsoleUsersCacheService implements IConsoleUsersCacheService {
    private IConsoleUsersCache cache = new ConsoleUsersCache();

    @Override
    public void createTemporaryTable() {
        cache.createTemporaryTable();
    }

    @Override
    public void deleteTemporaryTable() {
        cache.deleteTemporaryTable();
    }

    @Override
    public void uploadMergeIfAbsent(List<User> users) {
        cache.uploadMergeIfAbsent(users);
    }

    @Override
    public void uploadMergeIfPresent(List<User> users) {
        cache.uploadMergeIfPresent(users);
    }

    @Override
    public void uploadRewrite(List<User> users) {
       cache.uploadRewrite(users);
    }

    @Override
    public boolean save(User user) {
        return cache.save(user);
    }

    @Override
    public User update(User user) {
        return cache.update(user);
    }

    @Override
    public User findOne(int id) {
        return cache.findOne(id);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return cache.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return cache.findByLastName(lastName);
    }

    @Override
    public List<User> findByEmail(String email) {
        return cache.findByEmail(email);
    }

    @Override
    public List<User> findByRole(String role) {
        return cache.findByRole(role);
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber) {
        return cache.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Iterable<User> findAll() {
        return cache.findAll();
    }

    @Override
    public int count() {
        return cache.count();
    }

    @Override
    public User delete(int id) {
        return cache.delete(id);
    }

    @Override
    public void deleteAll() {
        cache.deleteAll();
    }

    @Override
    public boolean exists(int id) {
        return cache.exists(id);
    }
}
