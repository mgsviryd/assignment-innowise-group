package com.sviryd.mikhail.dao.console;

import com.sviryd.mikhail.dao.entity.User;

public interface IConsoleUserDao {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
