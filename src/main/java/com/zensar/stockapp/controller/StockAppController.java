package com.zensar.stockapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stockapp.dto.StockDto;
import com.zensar.stockapp.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockAppController {
	
	@Autowired
	private StockService stockService;
	
//	@MessageMapping("/stocks")
//    @SendTo("/topic/stocks")
	@GetMapping(value = "stocks")
	public ResponseEntity<List<StockDto>> getStockPrice(){
		return new ResponseEntity<List<StockDto>>(stockService.getAllStockPrice(), HttpStatus.OK);
	}
}
