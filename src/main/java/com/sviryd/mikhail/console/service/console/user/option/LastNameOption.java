package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUserCacheService;

import java.util.Scanner;

public class LastNameOption extends Option {
    private IConsoleUserCacheService userService;

    public LastNameOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
    }

    public LastNameOption(String optionName, IConsoleUserCacheService userService) {
        super(optionName);
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) {
        final String lastName = scanner.nextLine();
        User user = userService.getUser();
        user.setLastName(lastName);
    }
}
