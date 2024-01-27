package com.CarSelling.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.CarSelling.project.model.Message;
import com.CarSelling.project.service.MessageService;

@RestController
@RequestMapping(path = "/api/messagecontroller", method = RequestMethod.GET)
public class MessageController {

    @Autowired
    private MessageService messagingService;

    @GetMapping("/sendMessage")
    public Message sendMessage(@RequestBody Message message) throws Exception {
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            message.setDate(currentDateTime);
            
           return messagingService.sendMessage(message);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{recipient}")
    public List<Message> getMessagesByRecipient(@PathVariable String recipient) {
        return messagingService.getMessagesByRecipient(recipient);
    }

}
