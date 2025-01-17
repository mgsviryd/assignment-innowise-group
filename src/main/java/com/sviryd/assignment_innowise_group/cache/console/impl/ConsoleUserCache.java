package com.sviryd.assignment_innowise_group.cache.console.impl;

import com.sviryd.assignment_innowise_group.cache.ConsoleCache;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.cache.console.IConsoleUserCache;
import com.sviryd.assignment_innowise_group.config.ConsoleConfig;

public class ConsoleUserCache implements IConsoleUserCache {
    private static final String CONSOLE_USER = ConsoleConfig.CONSOLE_USER_CACHE;
    @Override
    public User createTemporaryUser() {
        final User user = new User();
        ConsoleCache.put(CONSOLE_USER, user);
        return user;
    }

    @Override
    public void deleteTemporaryUser() {
        ConsoleCache.remove(CONSOLE_USER);
    }

    @Override
    public User clearFields() {
        return createTemporaryUser();
    }

    @Override
    public User update(User user) {
        return (User) ConsoleCache.put(CONSOLE_USER, user);
    }

    @Override
    public User getUser() {
        return (User) ConsoleCache.get(CONSOLE_USER);
    }
}
