package com.sviryd.assignment_innowise_group.cache.console;

import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.dao.user.IUserDao;

import java.util.List;

public interface IConsoleUsersCache extends IUserDao {
    void createTemporaryTable();
    void deleteTemporaryTable();
    void uploadMergeIfAbsent(List<User> users);
    void uploadMergeIfPresent(List<User> users);
    void uploadRewrite(List<User> users);
}
