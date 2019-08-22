package com.sviryd.mikhail.console.service.console.user.cache;

import com.sviryd.mikhail.console.dao.entity.User;

public interface IConsoleUserCacheService {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
