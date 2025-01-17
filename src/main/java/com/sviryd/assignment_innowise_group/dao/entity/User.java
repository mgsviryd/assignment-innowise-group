package com.sviryd.assignment_innowise_group.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private String email;
    private List<String> roles;
    private List<String> phoneNumbers;

    public List<String> getRoles() {
        if (roles == null) {
            return new ArrayList<>();
        }
        return roles;
    }

    public List<String> getPhoneNumbers() {
        if (phoneNumbers == null) {
            return new ArrayList<>();
        }
        return phoneNumbers;
    }
}
