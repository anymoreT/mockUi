package com.hdw.mockUi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleDao {
    String getRole(String username);
    String getPassword(String username);
}
