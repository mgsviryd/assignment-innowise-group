package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.option.Option;

public class SurnameOption extends Option {
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        String inp = m.getScanner().nextLine();
        User user = m.getUser();
        String prev = user.getSurname();
        user.setSurname(inp);
        m.updateViolationsUser();
        if (m.isViolationsUserPresent()) {
            user.setSurname(prev);
        }
    }
}
