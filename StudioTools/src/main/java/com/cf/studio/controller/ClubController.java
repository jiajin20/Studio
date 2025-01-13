package com.cf.studio.controller;

import com.cf.studio.entity.Club;
import com.cf.studio.service.ClubService;
import com.cf.studio.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    //创建工作室
    @PostMapping("/create")
    private R createClub(@RequestParam("name")String name,
                         @RequestParam("description")String description,
                         @RequestParam("advisor_name")String advisor_name) {
        int result = clubService.insertClub(name, description, advisor_name);
        if (result == 1)
            return R.successMsg("创建成功");
        else {
            return R.error("创建失败");
        }
    }
    //获取工作室列表
    @GetMapping("/list")
    private ResponseEntity <List<Club>>listClubs() {
        return ResponseEntity.ok(clubService.getAllClubs());
    }
    //上传工作室logo
    @PostMapping("imgUpDown")
    public R imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("id") int ID) throws IOException, SQLException {
        String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String projectRootPath = System.getProperty("user.dir");
        File uploadDir = new File(projectRootPath+"/static/img");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File destFile = new File(uploadDir, fileName);
        file.transferTo(destFile);
        // 拼接图片的 URL
        String imgurl = fileName;
        clubService.updatelogo(ID, imgurl);
        return R.success("上传社团logo成功", imgurl);
    }
}
