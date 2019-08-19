package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUsersService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUsersService;

import java.util.Scanner;

public class ShowUsersByEmailOption extends Option {
    private IConsoleUsersService usersService;

    public ShowUsersByEmailOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
    }

    public ShowUsersByEmailOption(String optionName, IConsoleUsersService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String input = scanner.nextLine();
        final Iterable<User> selected = usersService.findByEmail(input);
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
