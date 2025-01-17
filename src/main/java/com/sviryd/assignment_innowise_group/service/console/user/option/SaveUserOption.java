package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.dao.IUserService;

import java.util.Scanner;

public class SaveUserOption extends Option {
    private IUserService usersService;
    private IConsoleUserCacheService userService;

    public SaveUserOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
        this.userService = new ConsoleUserCacheService();
    }

    public SaveUserOption(String optionName, IUserService usersService, IConsoleUserCacheService userService) {
        super(optionName);
        this.usersService = usersService;
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final User user = userService.getUser();
        usersService.save(user);
        userService.clearFields();
    }
}
