package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.exception.OptionException;
import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.io.user.UserDownloader;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.dao.IUserService;

import java.io.File;
import java.util.Scanner;

public class DownloadUsersInNewFileOption extends Option {
    private IUserService service;
    private UserDownloader writer;

    public DownloadUsersInNewFileOption(String optionName) {
        super(optionName);
        this.service = new ConsoleUsersCacheService();
        this.writer = new UserDownloader();
    }

    public DownloadUsersInNewFileOption(String optionName, IUserService service, UserDownloader writer) {
        super(optionName);
        this.service = service;
        this.writer = writer;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.exists()) {
            throw new OptionException("That file already exists.");
        } else {
            try {
                writer.rewrite(file, service.findAll());
            } catch (Exception e) {
                throw new OptionException("Failed. " + e.getMessage());
            }
        }
    }
}
