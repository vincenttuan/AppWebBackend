package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.InvestorDao;
import com.service.model.Investor;

@Path("/investor")
public class InvestorService {
	private InvestorDao investorDao = new InvestorDao();
	// http://localhost:8080/AppWebBackend/service/investor/findall
	@Path("/findall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Investor> findall() {
		return investorDao.queryAllInvestor();
	}
}
