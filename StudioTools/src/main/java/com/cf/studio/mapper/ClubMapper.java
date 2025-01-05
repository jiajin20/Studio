package com.cf.studio.mapper;

import com.cf.studio.entity.Club;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClubMapper {
    @Insert("insert into club (name, description,advisor_name) values (#{name}, #{description}, #{advisorName})")
    int insertClub(String name, String description, String advisorName);
    @Select("select * from club ")
    List<Club> getAllClubs();
    @Update("update club set logo=#{logo} where id=#{id}")
    int updateClubLogo(int id, String logo);
}
