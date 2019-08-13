package com.sviryd.mikhail.console.userExecution.option;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.userExecution.Option;
import lombok.AllArgsConstructor;

public class EnterFirstNameOption extends Option {
    @Override
    public Option execute(ConsoleUserModel model) {
        System.out.println(getOptionName() + ":");
        String s = model.getScanner().nextLine();
        User user = model.getUser();
        user.setFirstName(s);
        if (!isValid(user)){
            user.setFirstName(null);
            return this;
        }
        return getNext();
    }
}
