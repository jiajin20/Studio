package com.cf.studio.service;

import com.cf.studio.entity.Club;

import java.util.List;

public interface ClubService {
    int insertClub(String name, String description, String advisorName);
    List<Club> getAllClubs();
    int updatelogo(int id, String logo);
}
