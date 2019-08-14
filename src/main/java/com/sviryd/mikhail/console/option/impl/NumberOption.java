package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class NumberOption extends Option{
    private int index;
    @Override
    public void execute(ConsoleUserModel m) {
        print();
        String inp = m.getScanner().nextLine();
        User user = m.getUser();
        List<String> numbs = user.getPhoneNumbers();
        String prev = null;
        if (index < numbs.size()){
            prev = numbs.get(index);
            numbs.set(index,inp);
        }else {
            numbs.add(inp);
        }
        user.setPhoneNumbers(numbs);
        m.updateViolationsUser();
        if (m.isViolationsUserPresent()){
            if (index < numbs.size()){
                numbs.set(index,prev);
            }else {
                numbs.remove(numbs.size()-1);
            }
            user.setPhoneNumbers(numbs);
        }
    }
}
