package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.exception.RepeatPreventException;
import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.service.validation.console.user.PhoneNumberSizeValidationService;

import javax.validation.ValidationException;
import java.util.Scanner;

public class NumberExcessOption extends Option {
    private IConsoleUserCacheService userService;
    private PhoneNumberSizeValidationService sizeValidationService;

    public NumberExcessOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
        this.sizeValidationService = new PhoneNumberSizeValidationService();
    }

    public NumberExcessOption(String optionName, IConsoleUserCacheService userService, PhoneNumberSizeValidationService sizeValidationService) {
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
            user.setPhoneNumbers(null);
            throw new RepeatPreventException(e.getMessage());
        }
    }
}
