package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.OptionException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.dao.IUserService;

import java.util.Scanner;

public class ShowOneUserByIdOption extends Option {
    private IUserService usersService;

    public ShowOneUserByIdOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowOneUserByIdOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws OptionException {
        final String input = scanner.nextLine();
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
