package com.hdw.MockUi.service.impl;

import com.hdw.MockUi.entity.UserInfo;
import com.hdw.MockUi.service.IUserInterFace;
import com.hdw.MockUi.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInterFace implements IUserInterFace {

    @Autowired
    UserDao ud;

    @Override
    public UserInfo getUserByCardno(String cardno){
        return ud.getUserByCardno(cardno);
    }

    @Override
    public UserInfo getUserById(int id){
        return ud.getUserById(id);
    }

    @Override
    public int getIntUser() {
        return 0;
    }

    @Override
    public int insertUser(String cardno , String psname){

        return ud.insertUser(cardno,psname);
    }

    @Override
    public void testInsertUser(String cardno , String psname){

         ud.testInsertUser(cardno,psname);
    }

    @Override
    public List<UserInfo> getAllUser(){

        return ud.getAllUser();
    }

    @Override
    public int deleteById(int id){

        return ud.deleteById(id);
    }

    @Override
    public int updateById(int id , String cardno , String psname){

        return ud.updateByid(id,cardno,psname);
    }
}
