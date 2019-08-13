package com.sviryd.mikhail.console;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@Size(min = 12,
        max = 12,
        message = "Number of unique roles must be in range from ${min} to ${max} inclusive.")
class TelephoneNumber {
    private String telephoneNumber;
}