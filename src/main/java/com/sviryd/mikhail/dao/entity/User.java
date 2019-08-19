package com.sviryd.mikhail.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private Integer id;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "[a-z0-9]+@[a-z]+.[a-z]+", message = "Your email is not like *@*.* where * is any sequence of characters and letters.")
    private String email;
    @Size(min = 1,
            max = 3,
            message = "Number of unique roles must be in range from ${min} to ${max} inclusive.")
    private List<String> roles;
    @Size(min = 1,
            max = 3,
            message = "Number of phone numbers must be in range from ${min} to ${max} inclusive.")
    private List<@Pattern(regexp = "375[0-9]{2}\\s[0-9]{7}",
            message = "Phone number mismatch '375** *******' template.") String> phoneNumbers;


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

    public List<String> getRoles() {
        if (roles == null) {
            return new ArrayList<>();
        }
        return roles;
    }

    public List<String> getPhoneNumbers() {
        if (roles == null) {
            return new ArrayList<>();
        }
        return phoneNumbers;
    }
}
