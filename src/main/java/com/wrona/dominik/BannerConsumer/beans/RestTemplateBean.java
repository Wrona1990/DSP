package com.wrona.dominik.BannerConsumer.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBean {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
