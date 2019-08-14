package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.UserWriter;
import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class DownloadAsOldOption extends Option {
    private UserWriter userWriter;
    @Override
    public void execute(ConsoleUserModel m) {
//        System.out.println("You want to rewrite or append (R/A): ");
        print();
        String f = m.getScanner().nextLine().trim();
        try {
            if (f.equals("R")) {
                userWriter.rewrite(m.getUsers());
            } else if (f.equals("A")) {
                userWriter.append(m.getUsers());
            } else {
                System.out.println("You entered wrong option. Try again.");
                m.setRepeat(true);
            }
        }catch (IOException e){
            System.out.println("Failed. "+e.getMessage()+" Try again");
            m.setRepeat(true);
        }
    }
}
