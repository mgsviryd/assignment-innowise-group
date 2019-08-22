package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.exception.NoFindElementsException;
import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.util.List;
import java.util.Scanner;

public class ShowUsersByLastNameOption extends Option {
    private IUserService usersService;

    public ShowUsersByLastNameOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowUsersByLastNameOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String lastName = scanner.nextLine();
        final List<User> selected = usersService.findByLastName(lastName);
        if (selected.isEmpty()) {
            throw new NoFindElementsException("No users with last name: " + lastName);
        }
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
