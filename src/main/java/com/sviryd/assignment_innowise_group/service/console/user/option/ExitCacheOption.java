package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.ExitException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;

import java.util.Scanner;

public class ExitCacheOption extends Option {
    private IConsoleUserCacheService userService;
    private IConsoleUsersCacheService usersService;

    public ExitCacheOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
        this.usersService = new ConsoleUsersCacheService();
    }

    public ExitCacheOption(String optionName, IConsoleUserCacheService userService, IConsoleUsersCacheService usersService) {
        super(optionName);
        this.userService = userService;
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        userService.deleteTemporaryUser();
        usersService.deleteTemporaryTable();
        throw new ExitException();
    }
}
