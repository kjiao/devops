package com.kjiao.devops.config;

import com.kjiao.devops.backend.service.EmailService;
import com.kjiao.devops.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by kjiao on 13/04/2017.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.devopskun/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
