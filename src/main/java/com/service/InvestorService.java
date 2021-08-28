package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.InvestorDao;
import com.service.dao.TransactionLogDao;
import com.service.model.Investor;

@Path("/investor")
public class InvestorService {
	private InvestorDao investorDao = new InvestorDao();
	private TransactionLogDao transactionLogDao = new TransactionLogDao();
	
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
		investor.setTransactionLogs(transactionLogDao.queryByInvestorId(id));
		return investor;
	}
	
	
}
