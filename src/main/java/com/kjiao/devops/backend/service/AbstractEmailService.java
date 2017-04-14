package com.kjiao.devops.backend.service;

import com.kjiao.devops.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kjiao on 14/04/2017.
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedback(FeedbackPojo feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("Feedback from " + feedback.getFirstName() + " " + feedback.getLastName());
        message.setText(feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedback(feedbackPojo));
    }
}
