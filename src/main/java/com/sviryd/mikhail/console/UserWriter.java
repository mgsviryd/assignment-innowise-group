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
    private List<User> users;
    private File dataFile;

    private void rewrite() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (User user : users)
                out.writeObject(user);
        }
    }

    private void append() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            out.reset();
            for (User user : users)
                out.writeObject(user);
        }
    }
}
