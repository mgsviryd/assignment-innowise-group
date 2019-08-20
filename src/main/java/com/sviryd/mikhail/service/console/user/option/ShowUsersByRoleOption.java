package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUsersService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUsersService;

import java.util.Scanner;

public class ShowUsersByRoleOption extends Option {
    private IConsoleUsersService usersService;

    public ShowUsersByRoleOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
    }

    public ShowUsersByRoleOption(String optionName, IConsoleUsersService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String input = scanner.nextLine();
        final Iterable<User> selected = usersService.findByRole(input);
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
