package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.InvestorDao;
import com.service.dao.PortfolioDao;
import com.service.dao.StockPoolDao;
import com.service.model.Investor;
import com.service.model.Portfolio;
import com.service.model.StockPool;

@Path("/portfolio")
public class PortfolioService {
	private PortfolioDao portfolioDao = new PortfolioDao();
	// http://localhost:8080/AppWebBackend/service/portfolio/findall
	@Path("/findall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Portfolio> findall() {
		return portfolioDao.queryAllPortfolio();
	}
}
