package com.wrona.dominik.BannerConsumer.beans;

import com.wrona.dominik.BannerConsumer.services.BidderService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BidderServiceBean {

    @Bean
    public BidderService getBidderService() {
        return new BidderService();
    }
}
