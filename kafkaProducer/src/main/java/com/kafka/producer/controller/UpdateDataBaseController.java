package com.kafka.producer.controller;

import com.kafka.producer.entity.User;
import com.kafka.producer.service.UpdateDatabasePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/database")
public class UpdateDataBaseController {

    @Autowired
    private UpdateDatabasePublisher updateDatabaseService;

    @GetMapping
    public List<User> getTop10Result(){
        return updateDatabaseService.getTop10Result();
    }

    @GetMapping("/send")
    public void sendData(){
        updateDatabaseService.sendData();
    }

}
