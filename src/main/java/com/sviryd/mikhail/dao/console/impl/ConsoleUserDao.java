package com.sviryd.mikhail.dao.console.impl;

import com.sviryd.mikhail.dao.console.IConsoleUserDao;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.dao.hash.ConsoleHash;

public class ConsoleUserDao implements IConsoleUserDao {
    private static final String CONSOLE_USER = "CONSOLE_USER";

    @Override
    public User createTemporaryUser() {
        User user = getUser();
        if (user == null) {
            user = (User) ConsoleHash.put(CONSOLE_USER, new User());
        }
        return user;
    }

    @Override
    public void deleteTemporaryUser() {
        ConsoleHash.remove(CONSOLE_USER);
    }

    @Override
    public User clearFields() {
        return createTemporaryUser();
    }

    @Override
    public User update(User user) {
        return (User) ConsoleHash.put(CONSOLE_USER, user);
    }

    @Override
    public User getUser() {
        return (User) ConsoleHash.get(CONSOLE_USER);
    }
}
