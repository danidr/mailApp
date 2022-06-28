package com.gbtech.mail.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="to_email")
public class EmailTo {

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
        return "EmailTo{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailTo emailTo = (EmailTo) o;
        return Objects.equals(id, emailTo.id) && Objects.equals(mail, emailTo.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail);
    }
}
