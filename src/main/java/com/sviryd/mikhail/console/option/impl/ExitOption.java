package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.option.Option;

public class ExitOption extends Option {
    @Override
    public void execute(ConsoleUserModel model) {
        System.exit(0);
    }
}
