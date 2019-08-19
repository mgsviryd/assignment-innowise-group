package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.console.exception.OptionException;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUsersService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUsersService;

import java.util.Scanner;

public class ShowOneUserByIdOption extends Option {
    private IConsoleUsersService usersService;

    public ShowOneUserByIdOption(String optionName) {

        super(optionName);
        this.usersService = new ConsoleUsersService();
    }

    public ShowOneUserByIdOption(String optionName, IConsoleUsersService usersService) {
        super(optionName);
        this.usersService = usersService;
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
            System.out.println(one);
        } else {
            throw new OptionException("There is not user with id: " + input + ".");
        }
    }
}
