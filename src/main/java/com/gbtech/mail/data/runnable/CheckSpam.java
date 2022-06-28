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

        System.out.println("Iniciando hilo para la limpieza de correos procedentes de la lista de SPAM.");

        Date fechaHoraActual = null;
        Date fechaHoraToFind = null;
        Integer resultado = 0;

        try {
            do {
                Thread.sleep(5000);
                fechaHoraActual = new Date();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaHoraActual);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR, 22);

                fechaHoraToFind = calendar.getTime();

                //if (dateFormat.format(date).equals("22:51")) {
                if (fechaHoraActual.before(fechaHoraToFind)) {
                    System.out.println("Buscando correos SPAM procedentes de la direccion: " + mailSpam);

                    resultado = emailService.setEmailAsSpam(mailSpam);

                    if (resultado > 0){
                        System.out.println("Marcados " + resultado + " correos como SPAM, procedentes de: " + mailSpam);
                    }
                }

            } while (true);
        } catch (InterruptedException exc){
            System.out.println(mailSpam + "Interrumpido.");
        }

        System.out.println("Terminando " + mailSpam);

    }
}