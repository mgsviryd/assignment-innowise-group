package com.sviryd.mikhail.console.cache.console;

import com.sviryd.mikhail.console.dao.user.IUserDao;
import com.sviryd.mikhail.console.dao.entity.User;

import java.util.List;

public interface IConsoleUsersCache extends IUserDao{
    void createTemporaryTable();
    void deleteTemporaryTable();
    void uploadMergeIfAbsent(List<User> users);
    void uploadMergeIfPresent(List<User> users);
    void uploadRewrite(List<User> users);
}
