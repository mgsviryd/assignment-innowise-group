package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.option.Option;

public class ShowOption extends Option {
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        String inp = m.getScanner().nextLine();
        int i = -1;
        try {
            i = Integer.valueOf(inp);
            if (i < m.getUsers().size()) {
                System.out.println(m.getUsers().get(i));;
            }
        } catch (Exception e) {
            System.out.println("There is not user id: " + i + ". Try again.");
            m.setRepeat(true);
        }
    }
}
