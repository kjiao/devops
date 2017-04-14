package com.kjiao.devops.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kjiao on 14/04/2017.
 */
public class SmtpEmailService extends AbstractEmailService{

    /** The application logger */
    private static final Logger logger = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        logger.debug("Sending email for: {}", message);
        mailSender.send(message);
        logger.info("Email sent");
    }
}
