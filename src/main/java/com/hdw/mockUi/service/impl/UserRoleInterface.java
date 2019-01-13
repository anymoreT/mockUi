package com.hdw.mockUi.service.impl;

import com.hdw.mockUi.dao.UserDao;
import com.hdw.mockUi.dao.UserRoleDao;
import com.hdw.mockUi.service.IUserRoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleInterface implements IUserRoleInterface {
    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public String getRole(String userName) {
        return userRoleDao.getRole(userName);
    }
}
