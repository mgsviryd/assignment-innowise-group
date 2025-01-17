package com.sviryd.assignment_innowise_group.service.console.user.cache.impl;

import com.sviryd.assignment_innowise_group.cache.console.IConsoleUserCache;
import com.sviryd.assignment_innowise_group.cache.console.impl.ConsoleUserCache;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;

public class ConsoleUserCacheService implements IConsoleUserCacheService {
    private IConsoleUserCache cache = new ConsoleUserCache();
    @Override
    public User createTemporaryUser() {
        return cache.createTemporaryUser();
    }

    @Override
    public void deleteTemporaryUser() {
        cache.deleteTemporaryUser();
    }

    @Override
    public User clearFields() {
        return cache.clearFields();
    }

    @Override
    public User update(User user) {
        return cache.update(user);
    }

    @Override
    public User getUser() {
        return cache.getUser();
    }
}
