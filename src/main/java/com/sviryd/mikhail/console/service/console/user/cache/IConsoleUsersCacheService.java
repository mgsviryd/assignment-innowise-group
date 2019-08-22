package com.sviryd.mikhail.console.service.console.user.cache;

import com.sviryd.mikhail.console.dao.entity.User;
import com.sviryd.mikhail.console.service.dao.IUserService;

import java.util.List;

public interface IConsoleUsersCacheService extends IUserService {
    void createTemporaryTable();
    void deleteTemporaryTable();
    void uploadMergeIfAbsent(List<User> users);
    void uploadMergeIfPresent(List<User> users);
    void uploadRewrite(List<User> users);
}
