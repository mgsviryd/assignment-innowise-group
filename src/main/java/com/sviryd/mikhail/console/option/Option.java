package com.sviryd.mikhail.console.option;

import com.sviryd.mikhail.console.ConsoleUserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Option {
    protected String optionName;
    private Option next;

    public abstract void execute(ConsoleUserModel m);

    public void print() {
        System.out.println(optionName + ":  ");
    }
    public String toString(){return optionName;}
}
