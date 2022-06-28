package com.gbtech.mail.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="cc_email")
public class EmailCc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail")
    private String mail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "EmailCc{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailCc emailCc = (EmailCc) o;
        return Objects.equals(id, emailCc.id) && Objects.equals(mail, emailCc.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail);
    }
}
