
package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.ConsoleUsersService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUsersService;

import java.util.Scanner;

public class UpdateUserOption extends Option {
    private IConsoleUsersService usersService;
    private IConsoleUserService userService;

    public UpdateUserOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
        this.userService = new ConsoleUserService();
    }

    public UpdateUserOption(String optionName, IConsoleUsersService usersService, IConsoleUserService userService) {
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
