package com.sviryd.mikhail.service.console.user.dao;

import com.sviryd.mikhail.dao.entity.User;

public interface IConsoleUserService {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
