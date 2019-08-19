package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.console.exception.OptionException;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.ConsoleUsersService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUsersService;

import java.util.Scanner;

public class FindOneUserByIdOption extends Option {
    private IConsoleUsersService usersService;
    private IConsoleUserService userService;

    public FindOneUserByIdOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
        this.userService = new ConsoleUserService();
    }

    public FindOneUserByIdOption(String optionName, IConsoleUsersService usersService, IConsoleUserService userService) {
        super(optionName);
        this.usersService = usersService;
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws OptionException {
        final String input = scanner.next();
        final int id;
        try {
            id = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new OptionException("Problem: it is not numeric type.");
        }
        final User one = usersService.findOne(id);
        if (one != null) {
            userService.update(one);
        } else {
            throw new OptionException("There is not user with id: " + input + ".");
        }
    }
}
