package com.wrona.dominik.BannerConsumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BannerResponse model wrapping Banner pojo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerResponse {

    @JsonProperty("banners")
    private List<Banner> banners;
}
