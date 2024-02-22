package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.model.EmailRequest;
import com.FirstApp.FirstApp.model.RefundRequest;
import com.FirstApp.FirstApp.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/email-sender")
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){

        emailService.sendEmail(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage());

        return new ResponseEntity<>("Email sent Successfully!", HttpStatus.CREATED);

    }

}
