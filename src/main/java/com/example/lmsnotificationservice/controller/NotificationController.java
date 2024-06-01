package com.example.lmsnotificationservice.controller;

import com.example.lmsnotificationservice.dto.MessageDto;
import com.example.lmsnotificationservice.dto.UserDto;
import com.example.lmsnotificationservice.entity.Notification;
import com.example.lmsnotificationservice.service.NotificationService;
import com.example.lmsnotificationservice.specifications.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationService service;

    @Autowired
    private UserManager userManager;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotificationsForUser(@RequestHeader("Authorization") String token){

        UserDto dto = userManager.getUserProfile(token);

        if(dto.getId() == null)
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);

        List<Notification> notifications = service.getAllNotifications(dto.getId());

        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<Notification> markAsRead(@PathVariable UUID notificationId) throws Exception {
        Notification notification = service.markAsRead(notificationId);

        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDto dto){

        Notification notification = service.addNotification(
                dto.getRecipientId(),
                dto.getMessage()
        );

        messagingTemplate.convertAndSend("/topic/message",
                notification);

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
