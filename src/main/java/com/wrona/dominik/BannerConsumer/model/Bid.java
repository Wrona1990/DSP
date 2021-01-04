package com.wrona.dominik.BannerConsumer.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bid model
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bid {

    private String id;
    private long bannerId;
    private BigDecimal price;
}
