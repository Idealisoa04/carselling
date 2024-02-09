package com.CarSelling.project.service;

import com.CarSelling.project.model.NotificationMessage;
import com.google.firebase.FirebaseException;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    
    private FirebaseMessaging firebaseMessaging;
    
    public String sendNotificationByToken(NotificationMessage notificationMessage){
        Notification notif = Notification
        .builder()
        .setTitle(notificationMessage.getTitle())
        .setBody(notificationMessage.getBody())
        .setImage(notificationMessage.getImage())
        .build();

        Message message = Message
        .builder()
        .setToken(notificationMessage.getRecipientToken()) 
        .setNotification(notif)
        .putAllData(notificationMessage.getData())
        .build();

        try {
            firebaseMessaging.send(message);
            return "success";
        } catch (FirebaseException e) {
            e.printStackTrace();
            return "error sending notification";
        }
    }
}
