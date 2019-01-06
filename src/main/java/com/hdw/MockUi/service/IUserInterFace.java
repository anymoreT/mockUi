package com.hdw.MockUi.service;

import com.hdw.MockUi.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserInterFace {
    public UserInfo getUserByCardno(String cardno);
    public UserInfo getUserById(int id);
    public int getIntUser();
    public int insertUser(@Param("cardno") String cardno , @Param("psname") String psname);
    public void testInsertUser(@Param("cardno") String cardno , @Param("psname") String psname);
    public List<UserInfo> getAllUser();
    public int deleteById(int id);
    public int updateById(int id , String cardno , String psname);

}
