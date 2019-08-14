package com.sviryd.mikhail.console.option.impl;

import com.sviryd.mikhail.console.ConsoleUserModel;
import com.sviryd.mikhail.console.UserWriter;
import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DownloadOption extends Option {
    private UserWriter writer;
    @Override
    public void execute(ConsoleUserModel m) {
        print();
//        System.out.println("Download as new file? (Y/N): ");
        String f = m.getScanner().nextLine().trim();
        if (f.equals("Y")){
            new DownloadAsNewOption(writer).execute(m);
        }else if (f.equals("N")){
            new DownloadAsOldOption(writer).execute(m);
        }else {
            m.setRepeat(true);
        }
    }
}
