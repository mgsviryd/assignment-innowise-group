package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.NoFindElementsException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.service.dao.IUserService;

import java.util.List;
import java.util.Scanner;

public class ShowUsersByNumberOption extends Option {
    private IUserService usersService;

    public ShowUsersByNumberOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public ShowUsersByNumberOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String number = scanner.nextLine();
        final List<User> selected = usersService.findByPhoneNumber(number);
        if (selected.isEmpty()) {
            throw new NoFindElementsException("No users with phone number: " + number);
        }
        for (User user : selected) {
            System.out.println(user);
        }
    }
}
