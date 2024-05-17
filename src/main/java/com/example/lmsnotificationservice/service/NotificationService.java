package com.example.lmsnotificationservice.service;

import com.example.lmsnotificationservice.entity.Notification;
import com.example.lmsnotificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public void addNotification(UUID recipientId, String message){
        Notification notification = new Notification(
                UUID.randomUUID(),
                message,
                recipientId,
                false
        );

        repository.save(notification);

    }

    public List<Notification> getUnreadNotifications(UUID recipientId){
        return repository.findByRecipientIdAndIsReadFalse(recipientId);
    }

    public void markAsRead(UUID notificationId) throws Exception {
        Notification notification = repository.findById(notificationId)
                .orElseThrow(() -> new Exception("Notification not found"));

        notification.setRead(true);

        repository.save(notification);

    }

}
