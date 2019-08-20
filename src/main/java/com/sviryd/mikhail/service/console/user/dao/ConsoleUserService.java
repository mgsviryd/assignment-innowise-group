package com.sviryd.mikhail.service.console.user.dao;

import com.sviryd.mikhail.dao.console.IConsoleUserDao;
import com.sviryd.mikhail.dao.console.impl.ConsoleUserDao;
import com.sviryd.mikhail.dao.entity.User;

public class ConsoleUserService implements IConsoleUserService {
    private IConsoleUserDao dao = new ConsoleUserDao();
    @Override
    public User createTemporaryUser() {
        return dao.createTemporaryUser();
    }

    @Override
    public void deleteTemporaryUser() {
        dao.deleteTemporaryUser();
    }

    @Override
    public User clearFields() {
        return dao.clearFields();
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public User getUser() {
        return dao.getUser();
    }
}
