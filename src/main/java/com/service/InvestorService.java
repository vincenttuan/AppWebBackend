package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.InvestorDao;
import com.service.dao.StockPoolDao;
import com.service.dao.TransactionLogDao;
import com.service.dao.WatchListDao;
import com.service.model.Investor;
import com.service.model.StockPool;
import com.service.model.TransactionLog;
import com.service.model.WatchList;

@Path("/investor")
public class InvestorService {
	private InvestorDao investorDao = new InvestorDao();
	private TransactionLogDao transactionLogDao = new TransactionLogDao();
	private WatchListDao watchListDao = new WatchListDao();
	private StockPoolDao stockPoolDao = new StockPoolDao();
	
	// http://localhost:8080/AppWebBackend/service/investor/findall
	@Path("/findall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Investor> findall() {
		return investorDao.queryAllInvestor();
	}
	
	// http://localhost:8080/AppWebBackend/service/investor/1
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Investor getInvestor(@PathParam("id") Integer id) {
		Investor investor = investorDao.getInvestorById(id);
		// 組合關聯資料
		List<TransactionLog> transactionLogs = transactionLogDao.queryByInvestorId(id);
		List<WatchList> watchLists =  watchListDao.queryByInvestorId(id);
		investor.setTransactionLogs(transactionLogs);
		investor.setWatchLists(watchLists);
		
		transactionLogs.forEach(t -> {
			StockPool stockPool = stockPoolDao.getStockPool(t.getStockpoolid());
			t.setStockPool(stockPool);
		});
		
		return investor;
	}
	
	
}
