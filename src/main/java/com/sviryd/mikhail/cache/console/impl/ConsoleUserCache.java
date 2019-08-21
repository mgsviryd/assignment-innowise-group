package com.sviryd.mikhail.cache.console.impl;

import com.sviryd.mikhail.cache.console.IConsoleUserCache;
import com.sviryd.mikhail.config.ConsoleConfig;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.cache.ConsoleCache;

public class ConsoleUserCache implements IConsoleUserCache {
    private static final String CONSOLE_USER = ConsoleConfig.CONSOLE_USER_CACHE;
    @Override
    public User createTemporaryUser() {
        User user = getUser();
        if (user == null) {
            user = (User) ConsoleCache.put(CONSOLE_USER, new User());
        }
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
