package com.wrona.dominik.BannerConsumer.services;


import com.wrona.dominik.BannerConsumer.clients.BannersClient;
import com.wrona.dominik.BannerConsumer.model.Banner;
import com.wrona.dominik.BannerConsumer.model.BannerResponse;
import com.wrona.dominik.BannerConsumer.model.Bid;
import com.wrona.dominik.BannerConsumer.model.Size;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BidderServiceTest {

    @Mock
    private BannersClient bannersClient;
    @InjectMocks
    private BidderService bidderService;

    private List<Banner> banners = Arrays.asList(
            new Banner(1L, new Size(100, 100), new BigDecimal("10"), new BigDecimal("10"), true),
            new Banner(2L, new Size(200, 200), new BigDecimal("20"), new BigDecimal("20"), true),
            new Banner(3L, new Size(300, 300), new BigDecimal("30"), new BigDecimal("30"), true)
    );

    private List<Banner> inactiveBanners = Arrays.asList(
            new Banner(1L, new Size(100, 100), new BigDecimal("10"), new BigDecimal("10"), false),
            new Banner(2L, new Size(200, 200), new BigDecimal("20"), new BigDecimal("20"), false),
            new Banner(3L, new Size(300, 300), new BigDecimal("30"), new BigDecimal("30"), false)
    );

    @Test
    public void returnsBidForGivenAdSizeWhenFindsOne() {

        BannerResponse bannerResponse = new BannerResponse();
        bannerResponse.setBanners(banners);

        Mockito.when(bannersClient.getBannersResponse()).thenReturn(bannerResponse);

        Optional<Bid> bidUnderTest = bidderService.getBid("test", "100x100");

        Assert.assertEquals(1L, bidUnderTest.get().getBannerId());
    }

    @Test
    public void returnsEmptyOptionalWhenDoesNotFindBanner() {

        BannerResponse bannerResponse = new BannerResponse();
        bannerResponse.setBanners(banners);

        Mockito.when(bannersClient.getBannersResponse()).thenReturn(bannerResponse);

        Optional<Bid> bidUnderTest = bidderService.getBid("test", "500x500");

        Assert.assertFalse(bidUnderTest.isPresent());
    }

    @Test
    public void returnsEmptyOptionalWhenBannerIsNotActive() {

        BannerResponse bannerResponse = new BannerResponse();
        bannerResponse.setBanners(inactiveBanners);

        Mockito.when(bannersClient.getBannersResponse()).thenReturn(bannerResponse);

        Optional<Bid> bidUnderTest = bidderService.getBid("test", "100x100");

        Assert.assertFalse(bidUnderTest.isPresent());
    }

}
