package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.NoFindElementsException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.dao.IUserService;

import java.util.List;
import java.util.Scanner;

public class ShowUsersByFirstNameOption extends Option {
    private IUserService usersService;

    public ShowUsersByFirstNameOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowUsersByFirstNameOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String firstName = scanner.nextLine();
        final List<User> selected = usersService.findByFirstName(firstName);
        if (selected.isEmpty()) {
            throw new NoFindElementsException("No users with first name: " + firstName);
        }
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
