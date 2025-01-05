package com.cf.studio.mapper;

import com.cf.studio.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
 @Select("select * from user where email=#{email} and password=#{password}")
 User login(String email,String password);
 @Insert("insert into user(username,email,password,role) values(#{name},#{email},#{password},#{role})")
 int register(String name, String password, String email, String role);
 // 检查邮箱是否存在
 @Select("SELECT COUNT(*) FROM user WHERE email = #{email}")
 int checkEmailExists(String email);
 @Select("select password from user where email=#{email}")
 String getUserPassword(String email);
}
