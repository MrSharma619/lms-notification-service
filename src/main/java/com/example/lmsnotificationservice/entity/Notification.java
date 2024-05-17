package com.example.lmsnotificationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
@Data
//when a teacher assigns a task to a student this will send notification to FE using web socket
//when a student submits task, notification sent to teacher
public class Notification {

    @Id
    private UUID id;

    private String message;

    private UUID recipientId;

    private boolean isRead;

}
