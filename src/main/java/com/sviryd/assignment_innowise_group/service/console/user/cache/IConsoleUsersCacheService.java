package com.sviryd.assignment_innowise_group.service.console.user.cache;

import com.sviryd.assignment_innowise_group.dao.entity.User;
import com.sviryd.assignment_innowise_group.service.dao.IUserService;

import java.util.List;

public interface IConsoleUsersCacheService extends IUserService {
    void createTemporaryTable();
    void deleteTemporaryTable();
    void uploadMergeIfAbsent(List<User> users);
    void uploadMergeIfPresent(List<User> users);
    void uploadRewrite(List<User> users);
}
