package com.cf.studio.controller;

import com.cf.studio.entity.Notification;
import com.cf.studio.service.TipsService;
import com.cf.studio.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipsController {
    @Autowired
    private TipsService tipsService;

    @PostMapping("/send")
    public R send(@RequestParam("title") String title,
                  @RequestParam("content") String content,
                  @RequestParam("sendname") String sendname,
                  @RequestParam("type") String type) {
        int relut = tipsService.sendTips( title, content, sendname, type, null);
        if (relut == 1) {
            return R.successMsg("发布成功");
        } else {
            return R.error("发布失败");
        }
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Notification>> get() {
      return ResponseEntity.ok(tipsService.getTips());
    }
}
