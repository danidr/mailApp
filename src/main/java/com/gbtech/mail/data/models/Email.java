package com.gbtech.mail.data.models;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "mail")
@NamedNativeQuery(name = "Email.findMailByFromEmail", query = "SELECT * FROM mail m WHERE m.mail_from LIKE ?", resultClass = Email.class)
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "mail_date")
    private Date date;
    @Column(name = "mail_from")
    private String from;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mail_id")
    private List<EmailTo> to;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mail_id")
    private List<EmailCc> cc;
    @Column(name = "mail_body")
    private String body;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "mail_state")
    private State state;

    public Email() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

        if (this.to != null){
            this.to.clear();

            if (to != null){
                this.to.addAll(to);
            } else {
                this.to.removeAll(this.to);
            }
        } else {
            this.to = to;
        }
    }

    public List<EmailCc> getCc() {
        return cc;
    }

    public void setCc(List<EmailCc> cc) {

        if (this.cc != null){
            this.cc.clear();

            if (cc != null){
                this.cc.addAll(cc);
            } else {
                this.cc.removeAll(this.cc);
            }
        } else {
            this.cc = cc;
        }

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return "Email{" +
                "id=" + id +
                ", date='" + formatter.format(date) + '\'' +
                ", from='" + from + '\'' +
                ", to=" + to.toString() +
                ", cc=" + cc.toString() +
                ", body='" + body + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(from, email.from) && Objects.equals(to, email.to) && Objects.equals(cc, email.cc) && Objects.equals(body, email.body) && state == email.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, cc, body, state);
    }
}
