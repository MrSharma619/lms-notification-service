package com.example.lmsnotificationservice.controller;

import com.example.lmsnotificationservice.dto.MessageDto;
import com.example.lmsnotificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationService service;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDto dto){

        service.addNotification(
                dto.getRecipientId(),
                dto.getMessage()
        );

        messagingTemplate.convertAndSend("/topic/message",
                service.getUnreadNotifications(dto.getRecipientId()));

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload MessageDto dto){
        //from client handle here
    }

    //not really sure why this is used
    @SendTo("/topic/message")
    public String broadcastMessage(@Payload MessageDto dto){
        return "send to";
    }

}
