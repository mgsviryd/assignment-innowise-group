package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUserService;

import java.util.Scanner;

public class LastNameOption extends Option {
    private IConsoleUserService userService;

    public LastNameOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserService();
    }

    public LastNameOption(String optionName, IConsoleUserService userService) {
        super(optionName);
        this.userService = userService;
    }
    @Override
    public void process(Scanner scanner) {
        final String input = scanner.next();
        User user = userService.getUser();
        user.setLastName(input);
    }
}
