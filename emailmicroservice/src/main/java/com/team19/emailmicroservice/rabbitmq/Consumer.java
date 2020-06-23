package com.team19.emailmicroservice.rabbitmq;

import com.team19.emailmicroservice.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private EmailService emailService;

    /*
     * @RabbitListener anotira metode za kreiranje handlera za bilo koju poruku koja pristize,
     * sto znaci da ce se kreirati listener koji je konektovan na RabbitQM queue i koji ce
     * prosledjivati poruke metodi. Listener ce konvertovati poruku u odgovorajuci tip koristeci
     * odgovarajuci konvertor poruka.
     */
    @RabbitListener(queues="${registrationrejectqueue}")
    public void handlerForRejecting(String message) {
        emailService.sendEmailForRejectingRegistrationRequest(message);
    }

    @RabbitListener(queues="${registrationapprovequeue}")
    public void handlerForApproving(String message) {
        emailService.sendEmailForApprovingRegistrationRequest(message);
    }

    @RabbitListener(queues="${messagequeue}")
    public void handler(String message) {
        emailService.sendEmail(message);
    }
}
