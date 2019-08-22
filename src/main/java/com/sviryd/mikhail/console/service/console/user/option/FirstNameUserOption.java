package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUserCacheService;

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
