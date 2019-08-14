package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.UserWriter;
import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class DownloadAsNewOption extends Option {
    private UserWriter writer;
    @Override
    public void execute(ConsoleUserModel m) {
        System.out.println("Enter absolute path to file (including file name): ");
        String f = m.getScanner().nextLine();
        File file = new File(f);
        if (file.exists()){
            System.out.println("That file already exists. Try again.");
            m.setRepeat(true);
        }else {
            try {
                writer.rewrite(m.getUsers());
            } catch (IOException e) {
                System.out.println("Failed. "+e.getMessage()+" Try again");
                m.setRepeat(true);
            }
        }
    }
}
