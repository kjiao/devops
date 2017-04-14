package com.kjiao.devops.web.controllers;

import com.kjiao.devops.backend.service.EmailService;
import com.kjiao.devops.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kjiao on 13/04/2017.
 */
@Controller
public class ContactController {

    /** The application logger */
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    private static final String FEEDBACK_MODEL_KEY = "feedback";

    private static final String CONTACT_US_VIEW_NAME = "contact/contact";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value="/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model){
        FeedbackPojo feedback = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value="/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
        logger.debug("Feedback POJO content: {}", feedback);
        emailService.sendFeedbackEmail(feedback);
        return CONTACT_US_VIEW_NAME;
    }
}
