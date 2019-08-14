package com.sviryd.mikhail.console.option;

import com.sviryd.mikhail.console.ConsoleUserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ChosenOption extends Option {
    protected List<Option> options;

    public ChosenOption() {
        this.options = new LinkedList<>();
    }
    public ChosenOption(Option... options){
        this.options = new ArrayList<>(options.length);
        Collections.addAll(this.options, options);
    }

    @Override
    public void execute(ConsoleUserModel model) {
        print();
        String s = model.getScanner().nextLine();
        int i = getIndexOption(s);
        if (i != -1) {
            setNext(options.get(i));
        } else {
            setNext(this);
        }
    }

    private int getIndexOption(String s) {
        int i = -1;
        try {
            int actual = Integer.valueOf(s);
            if (actual >= 0 && actual < options.size()) {
                i = actual;
            }
        } catch (Exception ex) {
        }
        return i;
    }

    public void print() {
        if (options.size() > 0) {
            System.out.println("Options:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println("    " + i + ". " + options.get(i));
            }
        }
    }

    public void addOption(Option o) {
        options.add(o);
    }
}
