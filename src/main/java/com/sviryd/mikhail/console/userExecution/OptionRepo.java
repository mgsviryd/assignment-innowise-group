package com.sviryd.mikhail.console.userExecution;

import java.util.HashMap;

public class OptionRepo {
    private HashMap<String, Option> repo;

    public OptionRepo() {
        this.repo = new HashMap<>(16);
    }

    public Option getExecution(String name){
        return repo.get(name);
    }
    public void addExecution(String name, Option option){
        repo.put(name, option);
    }
}
