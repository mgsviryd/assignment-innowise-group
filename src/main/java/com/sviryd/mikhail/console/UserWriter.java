package com.sviryd.mikhail.console;

import lombok.AllArgsConstructor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@AllArgsConstructor
public class UserWriter {
    private File dataFile;

    public void rewrite(List<User> users) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (User user : users)
                out.writeObject(user);
        }
    }

    public void append(List<User> users) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            out.reset();
            for (User user : users)
                out.writeObject(user);
        }
    }
}
