package com.CarSelling.project.controller;

import java.util.List;

import com.CarSelling.project.Config.JwtService;
import com.CarSelling.project.entity.DiscussionEntity;
import com.CarSelling.project.model.Message;
import com.CarSelling.project.service.DiscussionService;
import com.CarSelling.project.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/discussioncontroller")
public class DiscussionController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private DiscussionService discussionService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/add")
    public ResponseEntity<String> insertDiscussion(@RequestParam (name = "iduser2") Integer iduser2,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            this.discussionService.insertDiscussion(Integer.valueOf(idUser), iduser2);
            return ResponseEntity.ok("Succes");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam (name = "iddiscussion") Integer iddiscussion) throws Exception{
        try{
            return ResponseEntity.ok(this.messageService.getMessageByDiscussion(iddiscussion));
        }catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/discussions")
    public ResponseEntity<List<DiscussionEntity>> getDiscussions(@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            return ResponseEntity.ok(this.discussionService.getAllDiscussion(Integer.valueOf(idUser)));
        }catch(Exception e){
            throw e;
        }
    }

    
}
