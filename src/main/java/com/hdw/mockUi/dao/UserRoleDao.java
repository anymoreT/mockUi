package com.hdw.mockUi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleDao {
    String getRole(@Param("userName") String userName);
    String getPassword(@Param("userName") String userName);
}
