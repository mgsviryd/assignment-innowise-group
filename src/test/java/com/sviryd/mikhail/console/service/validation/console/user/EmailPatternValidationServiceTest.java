package com.sviryd.mikhail.console.service.validation.console.user;

import com.sviryd.mikhail.console.service.validation.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;

public class EmailPatternValidationServiceTest {
    private EmailPatternValidationService service;
    private String regex;

    @Before
    public void init(){
        regex = "[a-z0-9]+@[a-z]+\\.[a-z]+";
        service = new EmailPatternValidationService(regex, "Data is not valid.");
    }
    @Test
    public void v1() throws ValidationException {
        service.validate("p@x.c");
    }
    @Test
    public void v2() throws ValidationException {
        service.validate("part@x.com");
    }
    @Test(expected = ValidationException.class)
    public void v3() throws ValidationException {
        service.validate("partxcom");
    }
    @Test(expected = ValidationException.class)
    public void v4() throws ValidationException {
        service.validate("part@xcom");
    }
    @Test(expected = ValidationException.class)
    public void v5() throws ValidationException {
        service.validate("part@.com");
    }
    @Test(expected = ValidationException.class)
    public void v6() throws ValidationException {
        service.validate("part@x.com1");
    }
    @Test(expected = ValidationException.class)
    public void v7() throws ValidationException {
        service.validate("part@x1.com");
    }
}