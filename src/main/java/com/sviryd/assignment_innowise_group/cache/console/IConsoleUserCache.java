package com.sviryd.assignment_innowise_group.cache.console;

import com.sviryd.assignment_innowise_group.dao.entity.User;

public interface IConsoleUserCache {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
