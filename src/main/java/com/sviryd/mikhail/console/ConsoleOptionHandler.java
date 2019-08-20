package com.sviryd.mikhail.console;

import com.sviryd.mikhail.console.option.Option;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsoleOptionHandler {
    private Map<Integer, Option> options;
    private Option open;

    public ConsoleOptionHandler() {
        this.options = new HashMap<>();
    }

    public void addOption(int id, Option option) {
        options.put(id, option);
    }

    public Option getOption(int id) {
        return options.get(id);
    }

    public void setNext(int fromId, int toId) {
        options.get(fromId).setNext(options.get(toId));
    }

    public void setOpenOption(int id) {
        open = options.get(id);
    }

    public Option getOpenOption() {
        return open;
    }
}
