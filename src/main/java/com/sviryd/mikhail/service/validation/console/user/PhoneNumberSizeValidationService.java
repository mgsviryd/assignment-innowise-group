package com.sviryd.mikhail.service.validation.console.user;

import com.sviryd.mikhail.dao.entity.User;
import lombok.AllArgsConstructor;

import javax.validation.ValidationException;

@AllArgsConstructor
public class PhoneNumberSizeValidationService {
    private static final int MIN = 1;
    private static final int MAX = 3;
    public static final String MESSAGE = "Number of phone numbers must be in range from " + MIN + " to " + MAX + " inclusive.";
    private int min;
    private int max;
    private String message;

    public PhoneNumberSizeValidationService() {
        this.min = MIN;
        this.min = MAX;
        this.message = MESSAGE;
    }

    public void validate(User user) throws ValidationException {
        final int size = user.getRoles().size();
        if (size < min || size > max) {
            throw new ValidationException(message);
        }
    }
}
