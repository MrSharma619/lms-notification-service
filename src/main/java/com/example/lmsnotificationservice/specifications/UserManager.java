package com.example.lmsnotificationservice.specifications;

import com.example.lmsnotificationservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//configure open feign to communicate with other microservices
@FeignClient(name = "USER-SERVICE", url = "http://localhost:5001")
public interface UserManager {

    @GetMapping("/api/user/profile")
    public UserDto getUserProfile(@RequestHeader("Authorization") String token);

}
