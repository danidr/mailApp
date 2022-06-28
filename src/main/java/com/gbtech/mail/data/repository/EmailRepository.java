package com.gbtech.mail.data.repository;

import com.gbtech.mail.data.models.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    List<Email> findMailByFromEmail(String fromEmailAddress);
}