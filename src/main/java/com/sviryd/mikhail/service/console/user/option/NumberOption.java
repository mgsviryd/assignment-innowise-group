package com.sviryd.mikhail.service.console.user.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.console.user.dao.ConsoleUserService;
import com.sviryd.mikhail.service.console.user.dao.IConsoleUserService;
import com.sviryd.mikhail.service.validation.console.user.PhoneNumberPatternValidationService;

import java.util.List;
import java.util.Scanner;

public class NumberOption extends Option {
    private IConsoleUserService userService;
    private PhoneNumberPatternValidationService patternValidationService;

    public NumberOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserService();
        this.patternValidationService = new PhoneNumberPatternValidationService();
    }

    public NumberOption(String optionName, IConsoleUserService userService, PhoneNumberPatternValidationService patternValidationService) {
        super(optionName);
        this.userService = userService;
        this.patternValidationService = patternValidationService;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String input = scanner.nextLine();
        patternValidationService.validate(input);
        final User user = userService.getUser();
        final List<String> phoneNumbers = user.getPhoneNumbers();
        phoneNumbers.add(input);
        user.setPhoneNumbers(phoneNumbers);
    }
}
