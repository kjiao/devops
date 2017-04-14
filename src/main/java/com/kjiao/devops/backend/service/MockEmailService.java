package com.kjiao.devops.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kjiao on 14/04/2017.
 */
public class MockEmailService extends AbstractEmailService{

    /** The application logger */
    private static final Logger logger = LoggerFactory.getLogger(MockEmailService.class);
    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        logger.debug("Simulating an email service." );
        logger.info(message.toString());
        logger.debug("Email sent");
    }
}
