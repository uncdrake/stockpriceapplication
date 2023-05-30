package com.zensar.stockapp.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import com.zensar.stockapp.dto.StockDto;
import com.zensar.stockapp.service.StockService;

@WebMvcTest(StockAppController.class)
public class TestStockAppController {
	
	@MockBean
	StockService stockService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetAllStocks() throws Exception {
		List<StockDto> stockList = new ArrayList<StockDto>();
		stockList.add(new StockDto(4000, "Zensar", 95.12));
		when(stockService.getAllStockPrice()).thenReturn(stockList);

		MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8001/stocks"))
				.andExpect(status().isOk()).andReturn();
		String response = mvcResult.getResponse().getContentAsString();
		assertTrue(response.contains("Zensar"));
	}
}
