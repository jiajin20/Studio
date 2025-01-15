package com.cf.studio.mapper;

import com.cf.studio.dto.UserDto;
import com.cf.studio.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface UserMapper {
 //登录
 @Select("select * from user where email=#{email} and password=#{password}")
 User login(String email,String password);
 //注册
 @Insert("insert into user(username,email,password,role) values(#{name},#{email},#{password},#{role})")
 int register(String name, String password, String email, String role);
 // 检查邮箱是否存在
 @Select("SELECT COUNT(*) FROM user WHERE email = #{email}")
 int checkEmailExists(String email);
 //获取用户密码
 @Select("select password from user where email=#{email}")
 String getUserPassword(String email);
//更新用户信息
 @Update({
         "<script>",
         "UPDATE user",
         "<set>",
         "<if test='updates.containsKey(\"bio\")'>bio = #{updates.bio},</if>",
         "<if test='updates.containsKey(\"qq\")'>qq = #{updates.qq},</if>",
         "<if test='updates.containsKey(\"wechat\")'>wechat = #{updates.wechat},</if>",
         "<if test='updates.containsKey(\"sexy\")'>sexy = #{updates.sexy},</if>",
         "<if test='updates.containsKey(\"password\")'>password = #{updates.password},</if>",
         "<if test='updates.containsKey(\"username\")'>username = #{updates.username},</if>",
         "</set>",
         "WHERE id = #{user.id}",
         "</script>"
 })
 int updateUser(@Param("user") UserDto user, @Param("updates") Map<String, Object> updates);
//获取用户信息
 @Select("select username,email,avatar,bio,qq,wechat,sexy,join_date from user where id=#{id}")
 User getUserById(int id);
//获取用户id通过email
 @Select("select id from user where email=#{email}")
 int getUserIdByEmail(String email);
}
