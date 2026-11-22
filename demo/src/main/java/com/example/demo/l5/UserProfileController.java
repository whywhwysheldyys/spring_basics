package com.example.demo.l5;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {
    @PostMapping("/l5/users/{userId}/profile")
    public String userInfo(
    @PathVariable Long userId,
    @RequestParam boolean publishStatus,
    @RequestBody ProfileDTO profile
    ) {
        return "Пользователь ID = " + userId
                + " | Статус публикации: " + publishStatus
                + " | Описание: " + profile.getBio()
                + " | Локация: " + profile.getLocation();
    }
}