package com.vtx.cht.crypto.channel.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtx.cht.crypto.channel.lib.RedisManager;
import com.vtx.cht.crypto.channel.model.CoinMarket;
import com.vtx.cht.crypto.channel.model.dto.CoinGeckoMarketDto;
import com.vtx.cht.crypto.channel.service.CoinGeckoService;

@Service
public class CoinGeckoServiceImpl implements CoinGeckoService {
  // https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&price_change_percentage=1h

  @Value("${api.coingecko.coin-market.url.base}")
  private String baseUrl;
  // api version
  @Value("${api.coingecko.coin-market.url.version}")
  private String versionUrl;
  // coinsMarketsEndpoint
  @Value("${api.coingecko.coin-market.url.coinsMarketsEndpoint}")
  private String coinsMarketsEndpointUrl;

  @Value("${api.coingecko.coin-market.param.vsCurrency}")
  private String vsCurrency;

  @Value("${api.coingecko.coin-market.param.ids:NULL}")
  private String ids;

  @Value("${api.coingecko.coin-market.param.order}")
  private String order;

  @Value("${api.coingecko.coin-market.param.per-page}")
  private String perPage;

  @Value("${api.coingecko.coin-market.param.page}")
  private String page;

  @Value("${api.coingecko.coin-market.param.sparkline}")
  private String sparkline;

  @Value("${api.coingecko.coin-market.param.price-change-percentage}")
  private String priceChangePercentage;

  @Value("${api.coingecko.coin-market.return.no-of-items}")
  private Integer noOfItems;

  @Autowired
  @Qualifier(value = "lucas")
  private RestTemplate restTemplate;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RedisManager redisManager;

  @Override
  public List<CoinMarket> getCoinMarketWithCache()
      throws JsonProcessingException {
    CoinMarket[] redisData =
        this.redisManager.get("coin-market", CoinMarket[].class);
    if (redisData != null) {
      return Arrays.asList(redisData);
    }
    List<CoinMarket> coinMarkets = this.getCoinMarket();
    this.redisManager.set("coin-market", coinMarkets, Duration.ofMinutes(1));
    return coinMarkets;
  }

  @Override
  public List<CoinMarket> getCoinMarket() {
    String url =
        UriComponentsBuilder.fromUriString(baseUrl).pathSegment(versionUrl)
            .path(coinsMarketsEndpointUrl)
            .queryParam("vs_currency", Optional.of(vsCurrency))
            .queryParamIfPresent("ids", Optional.ofNullable(ids))
            .queryParamIfPresent("order", Optional.ofNullable(order))
            .queryParamIfPresent("per_page", Optional.ofNullable(perPage))
            .queryParamIfPresent("page", Optional.ofNullable(page))
            .queryParamIfPresent("sparkline", Optional.ofNullable(sparkline))
            .queryParamIfPresent("price_change_percentage",
                Optional.ofNullable(priceChangePercentage))
            .build().toUriString();

    List<CoinGeckoMarketDto> coinGeckoMarketDtos = Arrays.asList(
        this.restTemplate.getForObject(url, CoinGeckoMarketDto[].class));
    return coinGeckoMarketDtos.stream().limit(noOfItems)
        .map(e -> modelMapper.map(e, CoinMarket.class))
        .collect(Collectors.toList());
  }
}
