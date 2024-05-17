package com.example.lmsnotificationservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MessageDto {

    private String message;

    private UUID recipientId;

}

