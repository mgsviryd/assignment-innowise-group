package com.sviryd.mikhail.console;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class ConsoleUserModel {
    private Scanner scanner;
    private List<User> users;
    private User user;

    public ConsoleUserModel() {
        scanner = new Scanner(System.in);
        users = new LinkedList<>();
        user = new User();
    }
}
