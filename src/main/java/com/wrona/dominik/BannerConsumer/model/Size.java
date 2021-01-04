package com.wrona.dominik.BannerConsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Size model, contained by Banner model
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Size {

    private int height;
    private int width;
}
