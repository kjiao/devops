package com.kjiao.devops.config;

import com.kjiao.devops.backend.service.EmailService;
import com.kjiao.devops.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by kjiao on 13/04/2017.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.devopskun/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
