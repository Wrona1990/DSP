package com.wrona.dominik.BannerConsumer.clients;

import com.wrona.dominik.BannerConsumer.model.BannerResponse;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * BannersClient - responsible for rest exchanges
 */
public class BannersClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8282/banners";
    private static final String HEADER_NAME = "Authorization";
    private static final String TOKEN = "28eb9316ac784699a92d3928ede68506";

    /**
     * Exchanges BASE_URL, HEADER_NAME and TOKEN for Json Response of a BannerResponse model
     * @return ResponseEntity<BannerResponse>
     */
    public ResponseEntity<BannerResponse> getBannersResponse() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(HEADER_NAME, TOKEN);

        return restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                new HttpEntity<>(HEADER_NAME, headers),
                BannerResponse.class);
    }
}
