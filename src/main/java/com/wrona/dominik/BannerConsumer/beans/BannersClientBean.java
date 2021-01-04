package com.wrona.dominik.BannerConsumer.beans;

import com.wrona.dominik.BannerConsumer.clients.BannersClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BannersClientBean {

    @Bean
    public BannersClient getBannersClient() {
        return new BannersClient();
    }
}
