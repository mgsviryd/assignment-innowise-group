package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.cache.IConsoleUserCacheService;
import com.sviryd.mikhail.service.console.user.cache.impl.ConsoleUserCacheService;
import com.sviryd.mikhail.service.validation.console.user.PhoneNumberPatternValidationService;

import java.util.List;
import java.util.Scanner;

public class NumberOption extends Option {
    private IConsoleUserCacheService userService;
    private PhoneNumberPatternValidationService patternValidationService;

    public NumberOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserCacheService();
        this.patternValidationService = new PhoneNumberPatternValidationService();
    }

    public NumberOption(String optionName, IConsoleUserCacheService userService, PhoneNumberPatternValidationService patternValidationService) {
        super(optionName);
        this.userService = userService;
        this.patternValidationService = patternValidationService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String number = scanner.nextLine();
        patternValidationService.validate(number);
        final User user = userService.getUser();
        final List<String> phoneNumbers = user.getPhoneNumbers();
        phoneNumbers.add(number);
        user.setPhoneNumbers(phoneNumbers);
    }
}
