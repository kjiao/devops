package com.kjiao.devops.web.i18n;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by kjiao on 12/04/2017.
 */
@Service
public class I18NService {

    /** The application logger */
    private static final Logger logger = LoggerFactory.getLogger(I18NService.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * returns a message for the given message id with local in session
     * @param messageId
     * @return
     */
    public String getMessage(String messageId) {
        logger.info("Returning i18n text for messageId {}", messageId);
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId, locale);
    }

    /**
     * returns a message for the given message id with local given
     * @param messageId
     * @param locale
     * @return
     */
    public String getMessage(String messageId, Locale locale) {
        return messageSource.getMessage(messageId, null, locale);
    }
}
