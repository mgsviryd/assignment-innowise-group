package com.sviryd.mikhail.console.userExecution.option;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.userExecution.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExitOption extends Option {
    @Override
    public Option execute(ConsoleUserModel model) {
        System.exit(0);
        return null;
    }
}
