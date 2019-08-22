package com.sviryd.mikhail.console.io.user;

import com.sviryd.mikhail.console.dao.entity.User;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserReader implements AutoCloseable {
    private ObjectInputStream inp;

    public UserReader(File fileData) throws IOException {
        inp = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileData)));
    }

    public User read() throws IOException, ClassNotFoundException {
        return (User) inp.readObject();
    }

    @Override
    public void close() throws Exception {
        inp.close();
    }
}
