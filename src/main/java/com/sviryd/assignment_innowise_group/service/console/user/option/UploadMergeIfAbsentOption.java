package com.sviryd.assignment_innowise_group.service.console.user.option;

import com.sviryd.assignment_innowise_group.console.option.Option;
import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.io.user.UserUploader;
import com.sviryd.assignment_innowise_group.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.assignment_innowise_group.service.console.user.cache.IConsoleUsersCacheService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class UploadMergeIfAbsentOption extends Option {
    private IConsoleUsersCacheService usersService;
    private UserUploader uploader;

    public UploadMergeIfAbsentOption(String optionName) {
        super(optionName);
        this.usersService = new ConsoleUsersCacheService();
        this.uploader = new UserUploader();
    }

    public UploadMergeIfAbsentOption(String optionName, IConsoleUsersCacheService usersService, UserUploader uploader) {
        super(optionName);
        this.usersService = usersService;
        this.uploader = uploader;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String input = scanner.nextLine();
        File file = new File(input);
        final List<User> users = uploader.upload(file);
        usersService.uploadMergeIfAbsent(users);
    }
}
