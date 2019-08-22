package com.sviryd.mikhail.console.io;

import com.sviryd.mikhail.console.dao.entity.User;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserDownloader {
    public void rewrite(File dataFile, Iterable<User> users) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (User user : users)
                out.writeObject(user);
        }
    }

    public void append(File dataFile, Iterable<User> users) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            out.reset();
            for (User user : users)
                out.writeObject(user);
        }
    }
}
