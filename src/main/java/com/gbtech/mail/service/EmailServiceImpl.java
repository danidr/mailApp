package com.gbtech.mail.service;

import com.gbtech.mail.data.models.Email;
import com.gbtech.mail.data.models.Estate;
import com.gbtech.mail.data.payloads.request.EmailRequest;
import com.gbtech.mail.data.payloads.response.MessageResponse;
import com.gbtech.mail.data.repository.EmailRepository;
import com.gbtech.mail.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Override
    public MessageResponse createEmail(EmailRequest emailRequest) {

        Email newEmail = new Email();

        newEmail.setMailDate(new Date());
        newEmail.setMailFrom(emailRequest.getFrom());
        newEmail.setMailTo(emailRequest.getTo());
        newEmail.setMailCc(emailRequest.getCc());
        newEmail.setMailBody(emailRequest.getBody());
        newEmail.setMailEstate(emailRequest.getEstate());

        emailRepository.save(newEmail);

        return new MessageResponse("New Email created successfully!");
    }

    @Override
    public Optional<Email> updateEmail(Integer emailId, EmailRequest emailRequest) {

        Optional<Email> email = emailRepository.findById(emailId);

        if (email.isEmpty() || !email.get().getMailEstate().equals(Estate.DRAFT)){

            throw new ResourceNotFoundException("Email", "id", emailId);

        } else {

            email.get().setMailDate(new Date());
            email.get().setMailFrom(emailRequest.getFrom());
            email.get().setMailTo(emailRequest.getTo());
            email.get().setMailCc(emailRequest.getCc());
            email.get().setMailBody(emailRequest.getBody());
            email.get().setMailEstate(emailRequest.getEstate());

            emailRepository.save(email.get());

            return email;
        }
    }

    @Override
    public void deleteEmail(Integer emailId) {

        /*
        if (emailRepository.getReferenceById(emailId).getId().equals(emailId)){
            emailRepository.deleteById(emailId);
        } else {
            throw new ResourceNotFoundException("Email", "id", emailId);
        }
        */

        Optional<Email> email = emailRepository.findById(emailId);

        if (email.isEmpty() || email.get().getMailEstate().equals(Estate.DELETED)){

            throw new ResourceNotFoundException("Email", "id", emailId);

        } else {

            email.get().setMailEstate(Estate.DELETED);

            emailRepository.save(email.get());
        }
    }

    @Override
    public Email getSingleEmail(Integer emailId) {
        return emailRepository.findById(emailId).orElseThrow(() -> new ResourceNotFoundException("Email", "id", emailId));
    }

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
