package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUserService;

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
        final String input = scanner.nextLine();
        final User user = userService.getUser();
        final List<String> roles = user.getRoles();
        roles.add(input);
        user.setRoles(roles);
    }
}
