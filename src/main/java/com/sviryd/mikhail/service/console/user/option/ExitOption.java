package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.ExitException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUsersService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUsersService;

import java.util.Scanner;

public class ExitOption extends Option {
    private IConsoleUserService userService;
    private IConsoleUsersService usersService;

    public ExitOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserService();
        this.usersService = new ConsoleUsersService();
    }

    public ExitOption(String optionName, IConsoleUserService userService, IConsoleUsersService usersService) {
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
