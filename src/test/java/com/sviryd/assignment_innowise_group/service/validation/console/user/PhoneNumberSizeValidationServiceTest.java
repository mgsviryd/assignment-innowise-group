package com.sviryd.assignment_innowise_group.service.validation.console.user;

import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.validation.console.user.PhoneNumberSizeValidationService;
import com.sviryd.assignment_innowise_group.service.validation.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneNumberSizeValidationServiceTest {
    private PhoneNumberSizeValidationService service;
    private User user;

    @Before
    public void init() {
        service = new PhoneNumberSizeValidationService(1, 3, "Data is not valid.");
        user = new User();
    }

    @Test
    public void v() throws ValidationException {
        user.setPhoneNumbers(Stream.generate(() -> "").limit(1).collect(Collectors.toList()));
        service.validate(user);
    }

    @Test
    public void v1() throws ValidationException {
        user.setPhoneNumbers(Stream.generate(() -> "").limit(3).collect(Collectors.toList()));
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v2() throws ValidationException {
        user.setPhoneNumbers(null);
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v3() throws ValidationException {
        user.setPhoneNumbers(Collections.emptyList());
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v4() throws ValidationException {
        user.setPhoneNumbers(Stream.generate(() -> "").limit(4).collect(Collectors.toList()));
        service.validate(user);
    }
}