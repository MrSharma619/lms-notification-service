package com.example.lmsnotificationservice.repository;

import com.example.lmsnotificationservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByRecipientIdAndIsReadFalse(UUID recipientId);

    List<Notification> findByRecipientId(UUID recipientId);

}
