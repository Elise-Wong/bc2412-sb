package com.bootcamp.swagger.demo_swagger.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.swagger.demo_swagger.controller.StockOperation;
import com.bootcamp.swagger.demo_swagger.dto.StockDTO;
import com.bootcamp.swagger.demo_swagger.dto.mapper.DTOMapper;
import com.bootcamp.swagger.demo_swagger.entity.StockEntity;
import com.bootcamp.swagger.demo_swagger.entity.mapper.EntityMapper;
import com.bootcamp.swagger.demo_swagger.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//can read 20250321 note
@RestController
public class StockController implements StockOperation{
  @Autowired
  private StockService stockService;
  @Autowired
  private DTOMapper dtoMapper; //address
  @Autowired
  private EntityMapper entityMapper; //address


  //@GetMapping(value = "/stock") //"/stock/{id}"
  //@ResponseStatus(value = HttpStatus.OK) //return 200
  //public StockDTO getStock(@RequestParam String symbol){ //Long id --> String symbol
  @Override
  public StockDTO getStock(String symbol) {
    StockEntity stockEntity = this.stockService.findStock(symbol).orElse(null);
      return this.dtoMapper.map(stockEntity);
  }

  //@PostMapping(value = "/stock")
  //@ResponseStatus(value = HttpStatus.CREATED) //201
  //public StockDTO createStock(@RequestBody StockDTO stockDTO) { //mostly use DTO, convention
  @Override
  public StockDTO createStock(StockDTO stockDTO) {
    StockEntity stockEntity = this.entityMapper.map(stockDTO);
    stockEntity = this.stockService.saveStock(stockEntity);
      return this.dtoMapper.map(stockEntity);
  }
  
  //@DeleteMapping(value = "/stock")
  //@ResponseStatus(value = HttpStatus.OK)
  //public StockDTO deleteStock(@RequestParam String symbol){
  @Override
  public void deleteStock(String symbol) {
    this.stockService.deleteStock(symbol);
  }

  //@PutMapping(value = "/stock") // update for profile
  //@ResponseStatus(value = HttpStatus.OK)
  //public StockDTO updateStock(@RequestParam String symbol, @RequestBody StockDTO stockDTO) { //RESTful是根據一個nom,  定協議的定義是否
  @Override
  public StockDTO updateStock(String symbol, StockDTO stockDTO) {
    StockEntity stockEntity = this.entityMapper.map(stockDTO);
    stockEntity = this.stockService.updateStock(symbol, stockEntity);
      return this.dtoMapper.map(stockEntity);
  }
  
  //@Requestapping(value = "/stock") //x
  //@ResponseStatus(value = HttpStatus.OK)
  //public StockDTO updateStock(@RequestParam String symbol, @RequestBody StockDTO stockDTO) {
  //  StockEntity stockEntity = this.entityMapper.map(stockDTO);
  //  stockEntity = this.stockService.updateStock(symbol, stockEntity);
  //    return this.dtoMapper.map(stockEntity);
  //}
  
  //@PatchMapping(value = "/stock") //interview question
  //@ResponseStatus(value = HttpStatus.OK)
  //public StockDTO patchStockDesc(@RequestParam String symbol, @RequestParam String stockDescription) {
    @Override
    public StockDTO patchStockDesc(String symbol, String stockDescription) {
    StockEntity stockEntity =
        this.stockService.patchStockDescription(symbol, stockDescription);
    return this.dtoMapper.map(stockEntity);
}
  
}
