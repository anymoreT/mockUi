package com.hdw.mockUi.dao;

import com.hdw.mockUi.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 通过主键id号码查询人员信息
     */
  //  @Select("select * from person where id = #{id}")
    UserInfo getUserById(@Param("id") int id);

    /**
     * 通过身份证号码查询人员信息
     */
  //  @Select("select * from person where cardno = #{cardno}")
    UserInfo getUserByCardno(@Param("cardno") String cardno);

    /**
     * 新增人员信息
     */
   // @Insert("insert into person(cardno,psname) values(#{cardno},#{psname})")
    int insertUser(@Param("cardno") String cardno, @Param("psname") String psname);

    void testInsertUser(@Param("cardno") String cardno, @Param("psname") String psname);

    /**
     * 查询所有人员信息
     */
  //  @Select("select * from person")
    List<UserInfo> getAllUser();

    /**
     * 通过id删除人员信息
     */
  //  @Delete("delete from person where id = #{id}")
    int deleteById(@Param("id") int id);

  //  @Update("update person set cardno=#{cardno},psname=#{psname} where id=#{id}")
    int updateByid(@Param("id") int id , @Param("cardno") String cardno,@Param("psname") String psname);
}
