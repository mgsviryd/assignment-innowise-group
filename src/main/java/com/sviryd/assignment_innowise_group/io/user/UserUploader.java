package com.sviryd.assignment_innowise_group.io.user;

import com.sviryd.assignment_innowise_group.dao.entity.User;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class UserUploader {
    public List<User> upload(File dataFile) throws ClassNotFoundException, IOException {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                users.add((User) in.readObject());
            }
        } catch (EOFException e) {
            return users;
        }
    }
}
