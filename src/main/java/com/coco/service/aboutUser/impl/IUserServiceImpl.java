package com.coco.service.aboutUser.impl;

import com.coco.dao.aboutUser.IUserDao;
import com.coco.model.dto.User;
import com.coco.model.pojo.UserPojo;
import com.coco.model.pojo.UserRolePojo;
import com.coco.service.aboutUser.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;;
    @Override
    public User getUserByUserAccount(String userAccount) {
        return userDao.getUserByUserAccount(userAccount);
    }

    @Override
    public int insertUser(UserPojo user) {
        userDao.insertUser(user);
        return user.getId();
    }

    @Override
    public int insertUserRole(UserRolePojo userRolePojo) {
        return userDao.insertUserRole(userRolePojo);
    }

    @Override
    public int getUserIdByUserAccount(String userAccount) {
        return userDao.getUserIdByUserAccount(userAccount);
    }

    @Override
    public String getUserHeadImageUrl(int userId) {
        return userDao.getUserHeadImageUrl(userId);
    }

    @Override
    public int updateUserHeadImage(int userId, String urlStr) {
        return userDao.updateUserHeadImage(userId,urlStr);
    }

    @Override
    public int insertUserHeadImage(int userId) {
        return userDao.insertUserHeadImage(userId);
    }


}