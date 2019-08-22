package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.exception.RepeatPreventException;
import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.console.service.validation.console.user.RolesSizeValidationService;
import com.sviryd.mikhail.console.service.validation.exception.ValidationException;

import java.util.Scanner;

public class RoleExcessOption extends Option {
    private IConsoleUserCacheService userService;
    private RolesSizeValidationService sizeValidationService;

    public RoleExcessOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
        this.sizeValidationService = new RolesSizeValidationService();
    }

    public RoleExcessOption(String optionName, IConsoleUserCacheService userService, RolesSizeValidationService sizeValidationService) {
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
