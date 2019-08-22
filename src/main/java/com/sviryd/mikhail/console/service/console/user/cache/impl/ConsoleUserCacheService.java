package com.sviryd.mikhail.console.service.console.user.cache.impl;

import com.sviryd.mikhail.console.cache.console.IConsoleUserCache;
import com.sviryd.mikhail.console.cache.console.impl.ConsoleUserCache;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.IConsoleUserCacheService;

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
