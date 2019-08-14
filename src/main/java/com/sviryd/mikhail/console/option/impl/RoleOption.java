package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.User;
import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class RoleOption extends Option {
    private int index;

    @Override
    public void execute(ConsoleUserModel m) {
        print();
        String inp = m.getScanner().nextLine();
        User user = m.getUser();
        List<String> roles = user.getRoles();
        String prev = null;
        if (index < roles.size()) {
            prev = roles.get(index);
            roles.set(index, inp);
        } else {
            roles.add(inp);
        }
        user.setRoles(roles);
        m.updateViolationsUser();
        if (m.isViolationsUserPresent()) {
            if (index < roles.size()) {
                roles.set(index, prev);
            } else {
                roles.remove(roles.size() - 1);
            }
            user.setRoles(roles);
        }
    }
}
