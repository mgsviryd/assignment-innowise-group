package com.sviryd.mikhail.console;

import com.sviryd.mikhail.console.option.Option;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Console {
    private ConsoleUserModel model;
    private Option option;

    public void open() {
        Option o = option;
        while (true){
            o.execute(model);
            if (model.isViolationsUserPresent()){
                printViolations();
            }else if(!model.isRepeat()){
                o = o.getNext();
            }
            model.refresh();
        }
    }
    private void printViolations(){
        model.getViolationsUser().forEach(System.out::println);
    }
}
