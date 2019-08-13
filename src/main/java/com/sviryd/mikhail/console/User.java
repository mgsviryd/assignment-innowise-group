package com.sviryd.mikhail.console;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private String firstName;
    private String surname;
    @Pattern(regexp = "[a-z0-9]+@[a-z]+.[a-z]+", message = "Your email is not like *@*.* where * is any sequence of characters and letters.")
    private String email;
    @Size(min = 1,
            max = 3,
            message = "Number of unique roles must be in range from ${min} to ${max} inclusive.")
    private Set<String> roles;
    @Size(min = 1,
            max = 3,
            message = "Number of telephones must be in range from ${min} to ${max} inclusive.")
    @Valid
    private List<TelephoneNumber> numbers;


    public void addTelephoneNumber(String number) {
        if (numbers == null) numbers = new ArrayList<>();
        numbers.add(new TelephoneNumber(number));
    }

    public void addRoles(String role) {
        if (roles == null) roles = new HashSet<>();
        roles.add(role);
    }

    public static void main(String[] args) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        User user = new User();
        user.setEmail("a@c1.c");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            violation.getMessage();
        }
    }
}
