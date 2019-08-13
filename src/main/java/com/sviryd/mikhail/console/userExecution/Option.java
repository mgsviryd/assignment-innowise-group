package com.sviryd.mikhail.console.userExecution;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Getter
@Setter
public abstract class Option {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    protected String optionName;
    private Option next;

    public abstract Option execute(ConsoleUserModel model);

    public boolean isValid(User user) {
        Set<ConstraintViolation<User>> violations = VALIDATOR.validate(user);
        violations.forEach(System.out::println);
        return violations.isEmpty();
    }

    public void print() {
        System.out.println(optionName + ":  ");
    }
}
