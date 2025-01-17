package com.sviryd.assignment_innowise_group.service.console.user.cache;

import com.sviryd.assignment_innowise_group.dao.entity.User;

public interface IConsoleUserCacheService {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
