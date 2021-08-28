package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.InvestorDao;
import com.service.dao.PortfolioDao;
import com.service.dao.StockPoolDao;
import com.service.dao.TransactionLogDao;
import com.service.dao.WatchListDao;
import com.service.model.Investor;
import com.service.model.Portfolio;
import com.service.model.StockPool;
import com.service.model.TransactionLog;
import com.service.model.WatchList;

@Path("/watchlist")
public class WatchListService {
	private WatchListDao watchListDao = new WatchListDao();
	// http://localhost:8080/AppWebBackend/service/watchlist/findall
	@Path("/findall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<WatchList> findall() {
		return watchListDao.queryAllWatchList();
	}
}
