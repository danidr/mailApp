package com.gbtech.mail.data.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date mailDate;
    private String mailFrom;
    @ElementCollection
    @CollectionTable(name="to_email", joinColumns=@JoinColumn(name="email_id"))
    @Column(name="email")
    private List<String> mailTo = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name="cc_email", joinColumns=@JoinColumn(name="email_id"))
    @Column(name="email")
    private List<String> mailCc = new ArrayList<>();
    private String mailBody;

    @Enumerated(EnumType.STRING)
    private Estate mailEstate;

    public Email() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMailDate() {
        return mailDate;
    }

    public void setMailDate(Date mailDate) {
        this.mailDate = mailDate;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public List<String> getMailTo() {
        return mailTo;
    }

    public void setMailTo(List<String> mailTo) {
        this.mailTo = mailTo;
    }

    public List<String> getMailCc() {
        return mailCc;
    }

    public void setMailCc(List<String> mailCc) {
        this.mailCc = mailCc;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public Estate getMailEstate() {
        return mailEstate;
    }

    public void setMailEstate(Estate mailEstate) {
        this.mailEstate = mailEstate;
    }

    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return "Email{" +
                "id=" + id +
                ", date='" + formatter.format(mailDate) + '\'' +
                ", from='" + mailFrom + '\'' +
                ", to=" + mailTo +
                ", cc=" + mailCc +
                ", body='" + mailBody + '\'' +
                ", estate=" + mailEstate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(mailFrom, email.mailFrom) && Objects.equals(mailTo, email.mailTo) && Objects.equals(mailCc, email.mailCc) && Objects.equals(mailBody, email.mailBody) && mailEstate == email.mailEstate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailFrom, mailTo, mailCc, mailBody, mailEstate);
    }
}
