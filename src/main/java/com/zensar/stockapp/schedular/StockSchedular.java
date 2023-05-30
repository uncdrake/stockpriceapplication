package com.zensar.stockapp.schedular;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zensar.stockapp.entity.StockEntity;
import com.zensar.stockapp.repository.StockRepository;

@Component
public class StockSchedular {
	@Autowired
	private StockRepository stockRepo;

	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	public void updateStockPriceForComanyApple() {
		StockEntity stocklist = stockRepo.findByName("APPLE");

		
		double currentStockPrice = stocklist.getPrice();
//		double minChange = -0.5; 
//		double maxChange = 0.5;
//		double randomChange = minChange + Math.random() * (maxChange - minChange);
		Random rand = new Random();
		double randomChange = rand.nextDouble(-5,5);
		double newStockPrice = currentStockPrice + randomChange;
		stocklist.setPrice(newStockPrice);

		stockRepo.save(stocklist);
	}
	
	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	public void updateStockPriceForComanyIbm() {
		StockEntity stocklist = stockRepo.findByName("IBM");

		
		double currentStockPrice = stocklist.getPrice();
		Random rand = new Random();
		double randomChange = rand.nextDouble(-5,5);
		double newStockPrice = currentStockPrice + randomChange;
		stocklist.setPrice(newStockPrice);

		stockRepo.save(stocklist);
	}
	
	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	public void updateStockPriceForComanyInfosys() {
		StockEntity stocklist = stockRepo.findByName("Infosys");

		
		double currentStockPrice = stocklist.getPrice();
		Random rand = new Random();
		double randomChange = rand.nextDouble(-5,5);
		double newStockPrice = currentStockPrice + randomChange;
		stocklist.setPrice(newStockPrice);

		stockRepo.save(stocklist);
	}
	
	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	public void updateStockPriceForComanyReliance() {
		StockEntity stocklist = stockRepo.findByName("Reliance");

		
		double currentStockPrice = stocklist.getPrice();
		Random rand = new Random();
		double randomChange = rand.nextDouble(-5,5);
		double newStockPrice = currentStockPrice + randomChange;
		stocklist.setPrice(newStockPrice);

		stockRepo.save(stocklist);
	}
	
	@Scheduled(fixedDelay = 3000) // Runs every 3 seconds
	public void updateStockPriceForComanyZensar() {
		StockEntity stocklist = stockRepo.findByName("Zensar");

		
		double currentStockPrice = stocklist.getPrice();
		Random rand = new Random();
		double randomChange = rand.nextDouble(-5,5);
		double newStockPrice = currentStockPrice + randomChange;
		stocklist.setPrice(newStockPrice);

		stockRepo.save(stocklist);
	}
}
