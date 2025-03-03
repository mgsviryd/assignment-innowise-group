package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;

import java.util.Scanner;

public class FirstNameUserOption extends Option {
    private IConsoleUserCacheService userService;

    public FirstNameUserOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
    }

    public FirstNameUserOption(String optionName, IConsoleUserCacheService userService) {
        super(optionName);
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) {
        final String firstName = scanner.nextLine();
        User user = userService.getUser();
        user.setFirstName(firstName);
    }
}
