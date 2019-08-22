package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.util.Scanner;

public class ShowAllUsersOption extends Option {
    private IUserService usersService;

    public ShowAllUsersOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowAllUsersOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final Iterable<User> all = usersService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
