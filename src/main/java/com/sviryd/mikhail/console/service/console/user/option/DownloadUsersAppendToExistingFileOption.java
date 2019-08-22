package com.sviryd.mikhail.console.service.console.user.option;

import com.sviryd.mikhail.console.console.exception.OptionException;
import com.sviryd.mikhail.console.console.option.Option;
import com.sviryd.mikhail.console.io.UserDownloader;
import com.sviryd.mikhail.console.service.console.user.cache.impl.ConsoleUsersCacheService;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.io.File;
import java.util.Scanner;

public class DownloadUsersAppendToExistingFileOption extends Option {
    private IUserService service;
    private UserDownloader writer;

    public DownloadUsersAppendToExistingFileOption(String optionName) {
        super(optionName);
        this.service = new ConsoleUsersCacheService();
        this.writer = new UserDownloader();
    }

    public DownloadUsersAppendToExistingFileOption(String optionName, IUserService service, UserDownloader writer) {
        super(optionName);
        this.service = service;
        this.writer = writer;
    }

    @Override
    public void process(Scanner scanner) throws Exception {
        final String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new OptionException("The file '" + file + "' does not exist.");
        } else {
            try {
                writer.append(file, service.findAll());
            } catch (Exception e) {
                throw new OptionException("Failed. " + e.getMessage());
            }
        }
    }
}
