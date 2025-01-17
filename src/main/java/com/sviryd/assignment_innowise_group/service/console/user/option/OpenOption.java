package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.ExitException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;

import java.util.Scanner;

public class OpenOption extends Option {
    private IConsoleUsersCacheService usersService;
    private IConsoleUserCacheService userService;

    public OpenOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
        this.userService = new ConsoleUserCacheService();
    }

    public OpenOption(String optionName, IConsoleUsersCacheService usersService, IConsoleUserCacheService userService) {
        super(optionName);
        this.usersService = usersService;
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws ExitException {
        usersService.createTemporaryTable();
        userService.createTemporaryUser();
    }
}
