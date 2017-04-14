package com.kjiao.devops.backend.service;

import com.kjiao.devops.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by kjiao on 14/04/2017.
 */
public interface EmailService {

    void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    void sendGenericEmailMessage(SimpleMailMessage message);
}
