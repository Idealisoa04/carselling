package com.CarSelling.project.controller;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.CarSelling.project.Config.JwtService;
import com.CarSelling.project.entity.DiscussionEntity;
import com.CarSelling.project.model.Message;
import com.CarSelling.project.service.DiscussionService;
import com.CarSelling.project.service.MessageService;

@RestController
@RequestMapping(path = "/api/messagecontroller", method = RequestMethod.GET)
public class MessageController {

    @Autowired
    private MessageService messagingService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/sendMessage")
    public Message sendMessage(@RequestBody Message message,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            LocalDateTime currentDateTime = LocalDateTime.now();
            message.setDate(currentDateTime);
            message.setSender(idUser);
            
           return messagingService.sendMessage(message);
            
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/saveIdannonce")
    public ResponseEntity<String> saveSession( @RequestParam(name = "idannonce") String idannonce,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("idannonce", idannonce);

        return  ResponseEntity.ok("idannonce");

    }

    @GetMapping("/getIdannonce")
    ResponseEntity<String> getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object valeur = session.getAttribute("idannonce");

        if (valeur != null) {
            return ResponseEntity.ok(valeur.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La valeur n'a pas été trouvée en session");
        }
    }

    @GetMapping("/{recipient}")
    public ResponseEntity<List<Message>> getMessagesByRecipient(@PathVariable String recipient,@RequestHeader(name = "Authorization") String authHeader) throws Exception{
        try{
            String jwt = authHeader.substring(7);
            String idUser = jwtService.extractUsername(jwt);
            DiscussionEntity discussion =  this.discussionService.getOneDiscussion(Integer.valueOf(idUser),Integer.valueOf(recipient));
            if(discussion == null){
                this.discussionService.insertDiscussion(Integer.valueOf(idUser), Integer.valueOf(recipient));
            }
            return ResponseEntity.ok(messagingService.getMessagesByRecipient(recipient));
        } catch (Exception e){
            throw e;
        }
    }

    // @GetMapping("/{iddiscussion}")
    // public List<Message> getMessages(@PathVariable Integer iddiscussion) {
    //     return messagingService.getMessagesByRecipient(recipient);
    // }
}
