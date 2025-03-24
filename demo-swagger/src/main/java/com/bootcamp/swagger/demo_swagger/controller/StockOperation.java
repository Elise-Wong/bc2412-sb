package com.bootcamp.swagger.demo_swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.swagger.demo_swagger.dto.StockDTO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface StockOperation {
  //does not affect the programme
  @Operation(summary = "Get Stock by Symbol."
    , description = "This endpoint is to get stock by symbol from DB.")
  @ApiResponses({
    @ApiResponse(responseCode = "200",
      content = {@Content(schema = @Schema(implementation = StockDTO.class), //可追蹤到class
        mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    @ApiResponse(responseCode = "400",
        content = {@Content(schema = @Schema())}
        )})
  @GetMapping(value = "/stock") //"/stock/{id}"
  @ResponseStatus(value = HttpStatus.OK) //return 200
  public StockDTO getStock(@RequestParam String symbol); //Long id --> String symbol

  @Operation(summary = "Create Stock by Symbol."
    , description = "This endpoint is to create stock by symbol from DB.")
  @ApiResponses({
    @ApiResponse(responseCode = "200",
      content = {@Content(schema = @Schema(implementation = StockDTO.class),
        mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    @ApiResponse(responseCode = "400",
        content = {@Content(schema = @Schema())}
        )})
  @PostMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.CREATED) //201
  public StockDTO createStock(@RequestBody StockDTO stockDTO); //mostly use DTO, convention

  @Hidden //swagger
  @DeleteMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  public StockDTO deleteStock(@RequestParam String symbol);


  @PutMapping(value = "/stock") // update for profile
  @ResponseStatus(value = HttpStatus.OK)
  public StockDTO updateStock(@RequestParam String symbol, @RequestBody StockDTO stockDTO); //RESTful是根據一個nom,  定協議的定義是否

  
  //@RequestMapping(value = "/stock")
  //@ResponseStatus(value = HttpStatus.OK)
  //public StockDTO updateStock(@RequestParam String symbol, @RequestBody StockDTO stockDTO);

  
  @PatchMapping(value = "/stock") //interview question
  @ResponseStatus(value = HttpStatus.OK)
  public StockDTO patchStockDesc(@RequestParam String symbol, @RequestParam String stockDescription);

  
}
