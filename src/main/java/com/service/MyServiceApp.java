package com.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/service")
public class MyServiceApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		// µù¥U Service
		Set<Class<?>> classes = new LinkedHashSet<>();
		classes.add(HelloService.class);
		classes.add(InvestorService.class);
		classes.add(StockPoolService.class);
		classes.add(PortfolioService.class);
		classes.add(TransactionLogService.class);
		classes.add(WatchListService.class);
		classes.add(PriceService.class);
		return classes;
	}
	
}
