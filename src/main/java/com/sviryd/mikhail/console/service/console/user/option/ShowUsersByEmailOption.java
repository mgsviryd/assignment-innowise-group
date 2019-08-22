package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.exception.NoFindElementsException;
import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.util.List;
import java.util.Scanner;

public class ShowUsersByEmailOption extends Option {
    private IUserService usersService;

    public ShowUsersByEmailOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowUsersByEmailOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String email = scanner.nextLine();
        final List<User> selected = usersService.findByEmail(email);
        if (selected.isEmpty()) {
            throw new NoFindElementsException("No users with email: " + email);
        }
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
