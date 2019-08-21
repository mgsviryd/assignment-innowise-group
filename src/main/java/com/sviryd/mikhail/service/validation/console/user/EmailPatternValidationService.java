package com.sviryd.mikhail.service.validation.console.user;

import com.sviryd.mikhail.service.validation.exception.ValidationException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailPatternValidationService {
    private static final String REGEX = "[a-z0-9]+@[a-z]+.[a-z]+";
    private static final String MESSAGE = "Your email is not like *@*.* where * is any sequence of characters and letters.";

    private String regex;
    private String message;

    public EmailPatternValidationService() {
        this.regex = REGEX;
        this.message = MESSAGE;
    }

    public void validate(String email) throws ValidationException {
        if (!email.matches(regex)) {
            throw new ValidationException(message);
        }
    }
}
