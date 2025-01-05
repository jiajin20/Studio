package com.cf.studio.controller;

import com.cf.studio.entity.Event;
import com.cf.studio.service.EventService;
import com.cf.studio.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping("/addEvent")
    public R addEvent(@RequestParam("name")String name,
                      @RequestParam("description")String description,
                      @RequestParam("event_time")String event_time,
                      @RequestParam("end_time")String end_time,
                      @RequestParam("location")String location,
                      @RequestParam("organizer_name")String organizer_name,
                      @RequestParam("club_id")int club_id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime eventtime = LocalDateTime.parse(event_time, formatter);
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime endtime = LocalDateTime.parse(end_time, formatter_1);
        int result =  eventService.addEvent(name,description,eventtime,endtime,location,"published",organizer_name,club_id);
        if (result>0){
            return R.successMsg("添加活动成功");
        }else {
            return R.error("添加活动失败");
        }
    }


    @PostMapping("/getEventByClubId")
    public ResponseEntity<List<Event>> getEventByClubId(@RequestParam("id")int id){
        return ResponseEntity.ok(eventService.getEventByClubId(id));
    }
}
