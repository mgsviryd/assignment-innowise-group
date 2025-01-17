package com.sviryd.assignment_innowise_group.console.option;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Option {
    protected String optionName;
    protected Option next;

    protected Option(String optionName) {
        this.optionName = optionName;
    }

    public abstract void process(Scanner scanner) throws Exception;

    public String toString() {
        return optionName;
    }
}
