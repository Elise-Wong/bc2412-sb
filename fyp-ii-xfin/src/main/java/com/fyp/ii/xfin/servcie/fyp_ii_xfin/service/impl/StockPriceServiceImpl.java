package com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.ResultRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.service.StockPriceService;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.QuoteEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.QuoteResponseEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.ResultEntity;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.entity.mapper.StockPriceEntityMapper;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.model.dto.QuoteDto;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.QuoteRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.QuoteResponseRepository;
import com.fyp.ii.xfin.servcie.fyp_ii_xfin.repository.QuoteRepository;

/*
@Service
public class StockPriceServiceImpl implements StockPriceService{
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private ResultRepository resultRepository;
  @Autowired
  private QuoteResponseRepository quoteResponseRepository;
  @Autowired
  private QuoteRepository quoteRepository;
  @Autowired
  private StockPriceEntityMapper stockPriceEntityMapper;
  

  @Override
  public List<QuoteDto> getStock(){
    String url = String
      .format("https://query1.finance.yahoo.com/v7/finance/quote?symbols=%s.HK&crumb=%s"
      , symbols,crumbKey);
     
    List<QuoteDto> quoteDtos = Arrays.asList(this.restTemplate.getForObject(url, QuoteDto[].class));
    //return Arrays.asList(this.restTemplate.getForObject(url, QuoteDto[].class));

    // Clear DB : 由小至大
    this.resultRepository.deleteAll();
    this.quoteResponseRepository.deleteAll();
    this.quoteRepository.deleteAll();

    // Save DB (procedures)
    quoteDtos.stream().forEach(e -> {
      QuoteEntity quoteEntity = this.quoteRepository.save(this.stockPriceEntityMapper.map(e));
    
    QuoteResponseEntity quoteResponseEntity = this.stockPriceEntityMapper.map(e.getQuoteResponse());
    quoteResponseEntity.setQuoteEntity(quoteEntity);
    this.quoteResponseRepository.save(quoteResponseEntity);

    ResultEntity resultEntity = this.stockPriceEntityMapper.map(e.getQuoteResponse().getResult());
    resultEntity.setQuoteResponseEntity(quoteResponseEntity);
    this.resultRepository.save(resultEntity);

    });

    return quoteDtos;


  }
 
}
  */