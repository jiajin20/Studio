package com.cf.studio.service;

import com.cf.studio.entity.Club;
import com.cf.studio.entity.Userclub;

import java.util.List;

public interface ClubService {
    // 添加工作室
    int insertClub(String name, String description, String advisorName);
    // 获取所有工作室
    List<Club> getAllClubs();
    //更新工作室logo
    int updatelogo(int id, String logo);
    //获取工作室成员信息根据工作室id
    List<Userclub> getClubById(int id);
}
