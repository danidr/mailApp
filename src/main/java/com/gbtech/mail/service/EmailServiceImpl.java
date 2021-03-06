package com.gbtech.mail.service;

import com.gbtech.mail.data.models.Email;
import com.gbtech.mail.data.models.State;
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

        newEmail.setDate(new Date());
        newEmail.setFrom(emailRequest.getFrom());
        newEmail.setTo(emailRequest.getTo());
        newEmail.setCc(emailRequest.getCc());
        newEmail.setBody(emailRequest.getBody());
        newEmail.setState(emailRequest.getEstate());

        emailRepository.save(newEmail);

        return new MessageResponse("New Email created successfully!");
    }

    @Override
    public Optional<Email> updateEmail(Integer emailId, EmailRequest emailRequest) {

        Optional<Email> email = emailRepository.findById(emailId);

        if (email.isEmpty() || !email.get().getState().equals(State.DRAFT)){

            throw new ResourceNotFoundException("Email", "id", emailId);

        } else {

            email.get().setDate(new Date());
            email.get().setFrom(emailRequest.getFrom());
            email.get().setTo(emailRequest.getTo());
            email.get().setCc(emailRequest.getCc());
            email.get().setBody(emailRequest.getBody());
            email.get().setState(emailRequest.getEstate());

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

        if (email.isEmpty() || email.get().getState().equals(State.DELETED)){

            throw new ResourceNotFoundException("Email", "id", emailId);

        } else {

            email.get().setState(State.DELETED);

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

    @Override
    public Integer setEmailAsSpam(String mailSpam) {

        Integer counter = 0;

        List<Email> spamList = emailRepository.findMailByFromEmail(mailSpam);

        for (Email email:spamList) {

            if (!email.getState().equals(State.SPAM)){

                counter ++;

                email.setState(State.SPAM);

                emailRepository.save(email);
            }
        }

        return counter;
    }
}
