package com.sviryd.mikhail.console.service.validation.console.user;

import com.sviryd.mikhail.console.service.validation.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;

public class PhoneNumberPatternValidationServiceTest {
    private PhoneNumberPatternValidationService service;
    private String regex;

    @Before
    public void init() {
        regex = "375[0-9]{2}\\s[0-9]{7}";
        service = new PhoneNumberPatternValidationService(regex, "Data is not valid.");
    }

    @Test
    public void v1() throws ValidationException {
        service.validate("37544 7313873");
    }

    @Test
    public void v2() throws ValidationException {
        service.validate("37501 0000000");
    }

    @Test(expected = ValidationException.class)
    public void v3() throws ValidationException {
        service.validate("37544 7");
    }

    @Test(expected = ValidationException.class)
    public void v4() throws ValidationException {
        service.validate("375447113873");
    }

    @Test(expected = ValidationException.class)
    public void v5() throws ValidationException {
        service.validate("37444 7113873");
    }
}