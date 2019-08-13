package com.sviryd.mikhail.console;

import com.sviryd.mikhail.console.userExecution.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Console {
    private ConsoleUserModel model;
    private Option option;

    public void open() {
        while (true){
            option = option.execute(model);
        }
    }
}
