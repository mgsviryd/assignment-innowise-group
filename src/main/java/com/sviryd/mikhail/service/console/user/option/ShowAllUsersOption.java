package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUsersService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUsersService;

import java.util.Scanner;

public class ShowAllUsersOption extends Option {
    private IConsoleUsersService usersService;

    public ShowAllUsersOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
    }

    public ShowAllUsersOption(String optionName, IConsoleUsersService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final Iterable<User> all = usersService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
