package com.gbtech.mail.data.runnable;

import com.gbtech.mail.service.EmailService;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckSpam implements ApplicationRunner {

    @Autowired
    EmailService emailService;

    private String mailSpam = "carl@gbtec.com";

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        System.out.println("Starting thread for cleaning mails from SPAM list");

        Date fechaHoraActual = null;
        Date fechaHoraToFind = null;
        Integer resultado = 0;

        do {
            fechaHoraActual = new Date();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaHoraActual);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 16);
            calendar.set(Calendar.HOUR, 00);

            fechaHoraToFind = calendar.getTime();

            if (fechaHoraActual.equals(fechaHoraToFind)) {
                System.out.println("Finding SPAM emails from: " + mailSpam);

                resultado = emailService.setEmailAsSpam(mailSpam);

                if (resultado > 0){
                    System.out.println("Marked " + resultado + " emails as SPAM, from: " + mailSpam);
                } else {
                    System.out.println("No SPAM found");
                }
            }

        } while (true);

    }
}