package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.OptionException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.service.dao.IUserService;

import java.util.Scanner;

public class DeleteUserByIdOption extends Option {
    private IUserService usersService;

    public DeleteUserByIdOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
    }

    public DeleteUserByIdOption(String optionName, IUserService usersService) {
        super(optionName);
        this.usersService = usersService;
    }

    @Override
    public void process(Scanner scanner) throws OptionException {
        final String input = scanner.nextLine();
        final int id;
        try {
            id = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new OptionException("Problem: it is not numeric type.");
        }
        final User delete = usersService.delete(id);
        if (delete == null) {
            throw new OptionException("There is not user with id: " + input + ".");
        }
    }
}
