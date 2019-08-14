package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.option.Option;

public class SaveUserOption extends Option {
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        User user = m.getUser();
        m.getUsers().add(user);
        m.setUser(new User());
        System.out.println("User was saved.");
    }
}
