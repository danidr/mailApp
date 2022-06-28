package com.gbtech.mail.data.payloads.request;

import com.gbtech.mail.data.models.EmailCc;
import com.gbtech.mail.data.models.EmailTo;
import com.gbtech.mail.data.models.State;

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
    private List<EmailTo> to;

    private List<EmailCc> cc;

    @NotBlank
    @NotNull
    private String body;

    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private State state;

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

    public List<EmailTo> getTo() {
        return to;
    }

    public void setTo(List<EmailTo> to) {
        this.to = to;
    }

    public List<EmailCc> getCc() {
        return cc;
    }

    public void setCc(List<EmailCc> cc) {
        this.cc = cc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public State getEstate() {
        return state;
    }

    public void setEstate(State state) {
        this.state = state;
    }
}
