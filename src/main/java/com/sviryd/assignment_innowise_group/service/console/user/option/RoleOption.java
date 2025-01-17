package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;

import java.util.List;
import java.util.Scanner;

public class RoleOption extends Option {
    private IConsoleUserCacheService userService;

    public RoleOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
    }

    public RoleOption(String optionName, IConsoleUserCacheService userService) {
        super(optionName);
        this.userService = userService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String role = scanner.nextLine();
        final User user = userService.getUser();
        final List<String> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
    }
}
