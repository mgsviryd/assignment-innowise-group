package com.sviryd.mikhail.console.io.user;

import com.sviryd.mikhail.console.dao.entity.User;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserWriter implements AutoCloseable {
    private ObjectOutputStream inp;

    public UserWriter(File fileData) throws IOException {
        inp = new ObjectOutputStream((new BufferedOutputStream((new FileOutputStream(fileData)))));
    }

    public void write(User user) throws IOException, ClassNotFoundException {
        inp.writeObject(user);
    }

    @Override
    public void close() throws Exception {
        inp.close();
    }
}
