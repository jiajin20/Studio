package com.cf.studio.mapper;

import com.cf.studio.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
 @Select("select * from user where email=#{email} and password=#{password}")
 User login(String email,String password);
}
