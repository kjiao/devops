package com.kjiao.devops.web.i18n;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by kjiao on 12/04/2017.
 */
@Service
public class I18NService {

    @Autowired
    private MessageSource messageSource;

    /**
     * returns a message for the given message id with local in session
     * @param messageId
     * @return
     */
    public String getMessage(String messageId) {
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
