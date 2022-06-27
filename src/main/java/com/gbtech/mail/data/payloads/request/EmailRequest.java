package com.gbtech.mail.data.payloads.request;

import com.gbtech.mail.data.models.Estate;

import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmailRequest {

    @NotBlank
    @NotNull
    private Date date;

    @NotBlank
    @NotNull
    @Email
    private String from;

    @NotBlank
    @NotNull
    private List<String> to;

    private List<String> cc;

    @NotBlank
    @NotNull
    private String body;

    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private Estate estate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}
