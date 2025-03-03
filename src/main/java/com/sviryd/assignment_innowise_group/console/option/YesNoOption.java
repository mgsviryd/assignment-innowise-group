package com.sviryd.assignment_innowise_group.console.option;

import com.sviryd.assignment_innowise_group.console.exception.OptionException;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class YesNoOption extends Option {
    public static final String YES = "Y";
    public static final String NO = "N";
    protected Option yesOption;
    protected Option noOption;

    public YesNoOption(String optionName, Option yesOption, Option noOption) {
        super(optionName);
        this.yesOption = yesOption;
        this.noOption = noOption;
    }

    @Override
    public void process(Scanner scanner) throws OptionException {
        final String input = scanner.nextLine();
        if (input.equalsIgnoreCase(YES)) {
            setNext(yesOption);
        } else if (input.equalsIgnoreCase(NO)) {
            setNext(noOption);
        } else {
            throw new OptionException("You entered wrong option. It can be only '" + YES + "' or '" + NO + "'.");
        }
    }

    @Override
    public String toString() {
        return optionName + " " + YES + "/" + NO;
    }
}
