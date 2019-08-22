package com.sviryd.mikhail.console.service.validation.console.user;

import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.validation.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoleSizeValidationServiceTest {
    private RoleSizeValidationService service;
    private User user;

    @Before
    public void init() {
        service = new RoleSizeValidationService(1, 3, "Data is not valid.");
        user = new User();
    }

    @Test
    public void v() throws ValidationException {
        user.setRoles(Stream.generate(() -> "").limit(1).collect(Collectors.toList()));
        service.validate(user);
    }

    @Test
    public void v1() throws ValidationException {
        user.setRoles(Stream.generate(() -> "").limit(3).collect(Collectors.toList()));
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v2() throws ValidationException {
        user.setRoles(null);
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v3() throws ValidationException {
        user.setRoles(Collections.emptyList());
        service.validate(user);
    }

    @Test(expected = ValidationException.class)
    public void v4() throws ValidationException {
        user.setRoles(Stream.generate(() -> "").limit(4).collect(Collectors.toList()));
        service.validate(user);
    }
}