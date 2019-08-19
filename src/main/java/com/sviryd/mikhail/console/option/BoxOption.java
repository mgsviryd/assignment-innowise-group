package com.sviryd.mikhail.console.option;

import com.sviryd.mikhail.console.exception.OptionException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class BoxOption extends Option {
    protected List<Box> options;

    public BoxOption(String nameOption) {
        super(nameOption);
        this.options = new ArrayList<>();
    }

    @Override
    public void process(Scanner scanner) throws OptionException {
        final String input = scanner.nextLine();
        try {
            final Integer i = Integer.valueOf(input);
            setNext(options.get(i).getOption());
        } catch (Exception e) {
            throw new OptionException("There is not any option with number " + input + ".");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(optionName);
        for (int i = 0; i < options.size(); i++) {
            sb.append("    " + i + ". " + options.get(i).getBoxName());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void addOption(String boxName, Option option) {
        options.add(new Box(boxName, option));
    }

    @AllArgsConstructor
    @Getter
    private static class Box {
        private String boxName;
        private Option option;
    }
}
