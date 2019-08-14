package com.sviryd.mikhail.console;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class ConsoleUserModel {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    private Scanner scanner;
    private List<User> users;
    private User user;
    private Set<ConstraintViolation<User>> violationsUser;
    private boolean repeat;

    public ConsoleUserModel() {
        scanner = new Scanner(System.in);
        users = new LinkedList<>();
        user = new User();
    }
    public void updateViolationsUser(){
        violationsUser = VALIDATOR.validate(user);
    }
    public boolean isViolationsUserPresent() {
        return violationsUser.isEmpty();
    }
    public void refresh(){
        violationsUser = null;
        repeat = false;
    }
}
