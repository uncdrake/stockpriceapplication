package com.zensar.stockapp.schedular;


import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.stockapp.service.StockService;
import com.zensar.stockapp.dto.StockDto;

@Component
@Transactional
@ComponentScan("com.zensar.stockapp")
public class StockPriceWebSocketHandler implements WebSocketHandler {

	
    private final StockService stockService;
    
    public StockPriceWebSocketHandler(StockService stockService) {
        this.stockService = stockService;
    }

	private WebSocketSession session;
	private Timer timer;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		this.session = session;
		startSendingStockPrices();
	}

	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		stopSendingStockPrices();
	}

	private void startSendingStockPrices() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				List<StockDto> stocks = stockService.getAllStockPrice();

				if (session.isOpen()) {
					try {
						String stockPricesJson = convertStockPricesToJson(stocks);
						session.sendMessage(new TextMessage(stockPricesJson));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}, 0, 3000);
	}

	private void stopSendingStockPrices() {
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	private List<StockDto> fetchLatestStockPrices() {
		return null;
	}

	private String convertStockPricesToJson(List<StockDto> stocks) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(stocks);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	

	}

	@Override
	public boolean supportsPartialMessages() {
		
		return false;
	}
}