package com.sviryd.mikhail.console.userExecution;

import com.sviryd.mikhail.console.ConsoleUserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GroupOption extends Option {
    protected Option[] options;
    public GroupOption(String optionName, Option... options) {
        if (options == null) new IllegalArgumentException("Argument options cannot be null.");
        if (options.length < 2) new IllegalArgumentException("Argument options cannot consists less than 2 options.");
        this.optionName = optionName;
        this.options = options;
    }

    @Override
    public Option execute(ConsoleUserModel model) {
        print();
        String s = model.getScanner().nextLine();
        int i = getIndexOption(s);
        if (i != -1) {
            return options[i];
        } else {
            return this;
        }
    }

    private int getIndexOption(String s) {
        int i = -1;
        try {
            int actual = Integer.valueOf(s);
            if (actual >= 0 && actual < options.length) {
                i = actual;
            }
        } catch (Exception ex) {
        }
        return i;
    }

    public void print() {
        if (options.length > 0) {
            System.out.println("Options");
            for (int i = 0; i < options.length; i++) {
                System.out.println("    " + i + ". " + options[i].getOptionName());
            }
        }
    }
}
