package com.sviryd.assignment_innowise_group.service.validation.console.user;

import com.sviryd.assignment_innowise_group.service.validation.exception.ValidationException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailPatternValidationService {
    private static final String REGEX = "[a-z0-9]+@[a-z]+\\.[a-z]+";
    private static final String MESSAGE = "Your email is not like *@^.^ where * is any sequence of letters and numbers " +
            "and ^ is any sequence of letters.";

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
