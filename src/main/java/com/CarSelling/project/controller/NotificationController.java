package com.CarSelling.project.controller;

import com.CarSelling.project.model.NotificationMessage;
import com.CarSelling.project.service.FirebaseMessagingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notification")
public class NotificationController {
    
    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    public String sendNotificationByToken(@RequestBody NotificationMessage notificationMessage){
        return firebaseMessagingService.sendNotificationByToken(notificationMessage);
    }
}
