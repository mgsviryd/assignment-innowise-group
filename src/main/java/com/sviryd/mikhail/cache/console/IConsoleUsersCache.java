package com.sviryd.mikhail.cache.console;

import com.sviryd.mikhail.dao.console.user.IUserDao;
import com.sviryd.mikhail.dao.entity.User;

import java.util.List;

public interface IConsoleUsersCache extends IUserDao{
    void createTemporaryTable();
    void deleteTemporaryTable();
    void uploadMergeIfAbsent(List<User> users);
    void uploadMergeIfPresent(List<User> users);
    void uploadRewrite(List<User> users);
}
