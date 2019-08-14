package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.option.Option;

public class DeleteByIdOption extends Option {
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        String inp = m.getScanner().nextLine();
        int i = -1;
        try {
            i = Integer.valueOf(inp);
            if (i < m.getUsers().size()) {
                m.getUsers().remove(i);
                System.out.println("User id: " + i + " was deleted.");
            }
        } catch (Exception e) {
            System.out.println("There is not user id: " + i + ". Try again.");
            setNext(this);
        }
    }
}
