package com.sviryd.mikhail.service.consoleUser.option;

import com.sviryd.mikhail.console.option.Option;
import com.sviryd.mikhail.dao.entity.User;
import com.sviryd.mikhail.service.consoleUser.ConsoleUserService;
import com.sviryd.mikhail.service.consoleUser.IConsoleUserService;
import com.sviryd.mikhail.service.validation.EmailPatternValidationService;

import java.util.Scanner;

public class EmailOption extends Option {
    private IConsoleUserService userService;
    private EmailPatternValidationService validationService;

    public EmailOption(String optionName) {
        super(optionName);
        this.userService = new ConsoleUserService();
        this.validationService = new EmailPatternValidationService();
    }

    public EmailOption(String optionName, IConsoleUserService userService, EmailPatternValidationService validationService) {
        super(optionName);
        this.userService = userService;
        this.validationService = validationService;
    }

    @Override
    public void process(Scanner scanner) {
        final String input = scanner.nextLine();
        User user = userService.getUser();
        validationService.validate(input);
        user.setEmail(input);
    }
}
