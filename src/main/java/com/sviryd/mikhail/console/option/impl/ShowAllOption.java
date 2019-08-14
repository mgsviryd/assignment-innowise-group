package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.option.Option;

public class ShowAllOption extends Option {
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        if (m.getUsers().isEmpty()){
            System.out.println("No one user is present.");
        }else {
            m.getUsers().forEach(System.out::println);
        }
    }
}
