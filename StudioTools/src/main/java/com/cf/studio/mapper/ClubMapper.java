package com.cf.studio.mapper;

import com.cf.studio.entity.Club;
import com.cf.studio.entity.Userclub;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClubMapper {
    //插入工作室信息
    @Insert("insert into club (name, description,advisor_name) values (#{name}, #{description}, #{advisorName})")
    int insertClub(String name, String description, String advisorName);
    //获取所有工作室信息
    @Select("select * from club ")
    List<Club> getAllClubs();
    //获取工作室信息根据工作室id
    @Select("select * from userclub where club_id=#{id}")
    List<Userclub> getClubById(int id);
    //更新工作室logo
    @Update("update club set logo=#{logo} where id=#{id}")
    int updateClubLogo(int id, String logo);
}
