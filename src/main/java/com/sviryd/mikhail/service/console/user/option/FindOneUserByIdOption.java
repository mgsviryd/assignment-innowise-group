package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.OptionException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.service.dao.IUserService;

import java.util.Scanner;

public class FindOneUserByIdOption extends Option {
    private IUserService usersService;
    private IConsoleUserCacheService userService;

    public FindOneUserByIdOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
        this.userService = new ConsoleUserCacheService();
    }

    public FindOneUserByIdOption(String optionName, IUserService usersService, IConsoleUserCacheService userService) {
        super(optionName);
        this.usersService = usersService;
        this.userService = userService;
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
            userService.update(one);
        } else {
            throw new OptionException("There is not user with id: " + input + ".");
        }
    }
}
