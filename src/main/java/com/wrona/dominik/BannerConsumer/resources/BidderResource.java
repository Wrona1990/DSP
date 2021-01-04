package com.wrona.dominik.BannerConsumer.resources;

import com.wrona.dominik.BannerConsumer.model.Bid;
import com.wrona.dominik.BannerConsumer.services.BidderService;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BidderResource [RestController] - responsible for handling "/banners" endpoints
 */
@RestController
@Validated
@RequestMapping(path = "/banners")
public class BidderResource {

    @Autowired
    private BidderService bidderService;

    private static final String AD_SIZE_PATTERN = "(\\\\d+)([x])(\\\\d+)";

    /**
     * /bidder endpoint
     * @param bidId bidId
     * @param adsize adSize of a specified pattern [AD_SIZE_PATTERN]
     * @return BidResponse implementation
     */
    @RequestMapping(value = "/bidder", method = RequestMethod.GET)
    public ResponseEntity<Bid> bid(@RequestParam String bidId,
                                             @Valid
                   @Pattern(regexp = AD_SIZE_PATTERN, message = "invalid adsize")
                   @RequestParam
                           String adsize) {

        Optional<Bid> bid = bidderService.getBid(bidId, adsize);

        return bid.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok().build());
    }
}
