package com.example.alert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alert.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notify")
    public ResponseEntity<?> sendNotification(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody NotificationRequest notificationRequest) {
        try {
            String token = authorizationHeader.replace("Bearer ", "");
            if (jwtTokenProvider.validateToken(token)) {
                // Check if the user can send a notification to the given email
                if (notificationService.canSendNotification(notificationRequest.getEmail())) {
                    notificationService.sendNotification(notificationRequest.getEmail(), notificationRequest.getMessage());
                    return ResponseEntity.ok(new NotificationResponse("sent successfully"));
                } else {
                    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
