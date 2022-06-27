package com.gbtech.mail.web;

import com.gbtech.mail.data.models.Email;
import com.gbtech.mail.data.payloads.request.EmailRequest;
import com.gbtech.mail.data.payloads.response.MessageResponse;
import com.gbtech.mail.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/all")
    public ResponseEntity<List<Email>> getAllEmails () {
        List<Email> emails = emailService.getAllEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Email> getEmailById (@PathVariable("id") Integer id) {
        Email email = emailService.getSingleEmail(id);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmail( @RequestBody EmailRequest email) {
        MessageResponse newEmail = emailService.createEmail(email);
        return new ResponseEntity<>(newEmail, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Optional<Email> updateEmail( @PathVariable Integer id, @RequestBody EmailRequest email) {
        return emailService.updateEmail(id, email);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmail(@PathVariable("id") Integer id) {
        emailService.deleteEmail(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
