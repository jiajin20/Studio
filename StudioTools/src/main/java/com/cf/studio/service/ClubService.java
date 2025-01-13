package com.cf.studio.service;

import com.cf.studio.entity.Club;

import java.util.List;

public interface ClubService {
    // 添加工作室
    int insertClub(String name, String description, String advisorName);
    // 获取所有工作室
    List<Club> getAllClubs();
    //更新工作室logo
    int updatelogo(int id, String logo);
}
