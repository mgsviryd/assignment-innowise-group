package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.RepeatPreventException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.assignment_innowise_group.service.validation.console.user.RoleSizeValidationService;
import com.sviryd.assignment_innowise_group.service.validation.exception.ValidationException;

import java.util.Scanner;

public class RoleExcessOption extends Option {
    private IConsoleUserCacheService userService;
    private RoleSizeValidationService sizeValidationService;

    public RoleExcessOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
        this.sizeValidationService = new RoleSizeValidationService();
    }

    public RoleExcessOption(String optionName, IConsoleUserCacheService userService, RoleSizeValidationService sizeValidationService) {
        super(optionName);
        this.userService = userService;
        this.sizeValidationService = sizeValidationService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final User user = userService.getUser();
        try {
            sizeValidationService.validate(user);
        } catch (ValidationException e) {
            user.setRoles(null);
            throw new RepeatPreventException(e.getMessage());
        }
    }
}
