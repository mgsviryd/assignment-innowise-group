package com.sviryd.mikhail.service.consoleUser;

import com.sviryd.mikhail.dao.entity.User;

public interface IConsoleUserService {
    User createTemporaryUser();
    void deleteTemporaryUser();
    User clearFields();
    User update(User user);
    User getUser();
}
