package com.sviryd.mikhail.service.validation.console.user;

import lombok.AllArgsConstructor;

import javax.validation.ValidationException;


@AllArgsConstructor
public class PhoneNumberPatternValidationService {
    private static final String REGEX = "375[0-9]{2}\\s[0-9]{7}";
    private static final String MESSAGE = "Phone number mismatch '375** *******' template.";

    private String regex;
    private String message;

    public PhoneNumberPatternValidationService() {
        this.regex = REGEX;
        this.message = MESSAGE;
    }

    public void validate(String string) throws ValidationException {
        if (!string.matches(regex)) {
            throw new ValidationException(message);
        }
    }
}
