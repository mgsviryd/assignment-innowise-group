package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.ExitException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUsersService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUsersService;

import java.util.Scanner;

public class OpenOption extends Option {
    private IConsoleUsersService usersService;
    private IConsoleUserService userService;

    public OpenOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersService();
        this.userService = new ConsoleUserService();
    }

    public OpenOption(String optionName, IConsoleUsersService usersService, IConsoleUserService userService) {
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
