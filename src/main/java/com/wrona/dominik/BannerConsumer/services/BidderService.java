package com.wrona.dominik.BannerConsumer.services;

import com.wrona.dominik.BannerConsumer.clients.BannersClient;
import com.wrona.dominik.BannerConsumer.model.Banner;
import com.wrona.dominik.BannerConsumer.model.BannerResponse;
import com.wrona.dominik.BannerConsumer.model.Bid;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * BannerService - responsible banner operations
 */
@Service
public class BidderService {

    @Autowired
    BannersClient bannersClient;

    /**
     * GetBid - responsible for returning:
     * Bid when banner in specified size has been found and is active,
     * EmptyBidResponse when no banner in specified size has been found
     * or banner with specified size is not active
     *
     * @param bidId  bidId
     * @param adSize adSize
     * @return BidResponse implementation
     */
    public Optional<Bid> getBid(String bidId, String adSize) {
        List<Integer> sizes = splitAdSize(adSize);
        int height = sizes.get(0);
        int width = sizes.get(1);

        ResponseEntity<BannerResponse> bannersResponse = bannersClient.getBannersResponse();

        List<Banner> banners = getBySize(marshall(bannersResponse), height, width);

        Banner banner = getWithHighestBidPrice(banners);

        if (banner.isActive()) {

            return Optional.of(new Bid(bidId, banner.getId(), banner.getBidPrice()));
        }

        return Optional.empty();
    }

    private List<Banner> getBySize(List<Banner> banners, int height, int width) {

        return banners
                .stream()
                .filter(banner -> banner.getSize().getHeight() == height
                        && banner.getSize().getWidth() == width)
                .collect(Collectors.toList());
    }

    private Banner getWithHighestBidPrice(List<Banner> banners) {
        Comparator<Banner> comparator = Comparator.comparing(Banner::getBidPrice);

        return banners.stream().max(comparator).orElse(new Banner());
    }

    private List<Integer> splitAdSize(String adSize) {
        String[] split = adSize.split("x");

        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<Banner> marshall(ResponseEntity<BannerResponse> response) {

        return response.getBody().getBanners();
    }
}
