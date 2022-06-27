package com.gbtech.mail.service;

import com.gbtech.mail.data.models.Email;
import com.gbtech.mail.data.payloads.request.EmailRequest;
import com.gbtech.mail.data.payloads.response.MessageResponse;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmailService {

    MessageResponse createEmail(EmailRequest emailRequest);

    Optional<Email> updateEmail(Integer emailId, EmailRequest emailRequest);

    void deleteEmail(Integer emailId);

    Email getSingleEmail(Integer emailId);

    List<Email> getAllEmails();
}
