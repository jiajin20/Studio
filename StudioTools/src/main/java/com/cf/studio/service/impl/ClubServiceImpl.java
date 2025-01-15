package com.cf.studio.service.impl;

import com.cf.studio.entity.Club;
import com.cf.studio.entity.Userclub;
import com.cf.studio.mapper.ClubMapper;
import com.cf.studio.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubService")
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    // 添加工作室
    @Override
    public int insertClub(String name, String description, String advisorName) {
       return clubMapper.insertClub(name, description, advisorName);
    }
    // 获取所有工作室
    @Override
    public List<Club> getAllClubs() {
        return clubMapper.getAllClubs();
    }
    //更新工作室logo
    @Override
    public int updatelogo(int id, String logo) {
        return clubMapper.updateClubLogo(id, logo);
    }

    @Override
    public List<Userclub> getClubById(int id) {
       return clubMapper.getClubById(id);
    }
}
