package com.sviryd.mikhail.console.userExecution.option;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.userExecution.Option;
import lombok.AllArgsConstructor;

public class EnterSurnameOption extends Option {
    @Override
    public Option execute(ConsoleUserModel model) {
        print();
        String s = model.getScanner().nextLine();
        User user = model.getUser();
        user.setSurname(s);
        if (!isValid(user)){
            user.setSurname(null);
            return this;
        }
        return getNext();
    }
}
