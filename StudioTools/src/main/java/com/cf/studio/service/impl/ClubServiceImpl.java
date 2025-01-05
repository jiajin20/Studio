package com.cf.studio.service.impl;

import com.cf.studio.entity.Club;
import com.cf.studio.mapper.ClubMapper;
import com.cf.studio.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClubService")
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Override
    public int insertClub(String name, String description, String advisorName) {
       return clubMapper.insertClub(name, description, advisorName);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubMapper.getAllClubs();
    }

    @Override
    public int updatelogo(int id, String logo) {
        return clubMapper.updateClubLogo(id, logo);
    }
}
