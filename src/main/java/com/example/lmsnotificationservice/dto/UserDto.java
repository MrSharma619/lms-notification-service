package com.example.lmsnotificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;

    private String password;

    private String email;

    //ROLE_TEACHER
    //ROLE_STUDENT
    private String role;

    private String fullName;
}
