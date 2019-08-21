package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.RepeatPreventException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.service.validation.console.user.RolesSizeValidationService;

import javax.validation.ValidationException;
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
