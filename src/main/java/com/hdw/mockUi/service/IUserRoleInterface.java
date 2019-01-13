package com.hdw.mockUi.service;

import com.hdw.mockUi.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserRoleInterface {

    public String getRole(String userName);


}
