package com.sviryd.mikhail.console.cache.console;

import com.sviryd.mikhail.console.dao.entity.User;

public interface IConsoleUserCache {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
