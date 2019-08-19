package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUserService;

import java.util.List;
import java.util.Scanner;

public class RoleOption extends Option {
    private IConsoleUserService userService;

    public RoleOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserService();
    }

    public RoleOption(String optionName, IConsoleUserService userService) {
        super(optionName);
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String input = scanner.next();
        final User user = userService.getUser();
        final List<String> roles = user.getRoles();
        roles.add(input);
    }
}
