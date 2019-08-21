package com.sviryd.mikhail.service.console.user.cache;

import com.sviryd.mikhail.dao.entity.User;

public interface IConsoleUserCacheService {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
