
package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.util.Scanner;

public class UpdateUserOption extends Option {
    private IUserService usersService;
    private IConsoleUserCacheService userService;

    public UpdateUserOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
        this.userService = new ConsoleUserCacheService();
    }

    public UpdateUserOption(String optionName, IUserService usersService, IConsoleUserCacheService userService) {
        super(optionName);
        this.usersService = usersService;
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final User user = userService.getUser();
        usersService.update(user);
        userService.clearFields();
    }
}
