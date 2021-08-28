package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.dao.StockPoolDao;
import com.service.model.StockPool;

@Path("/stockpool")
public class StockPoolService {
	private StockPoolDao stockPoolDao = new StockPoolDao();

	// http://localhost:8080/AppWebBackend/service/stockpool/findall
	@Path("/findall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StockPool> findall() {
		return stockPoolDao.queryAllStockPool();
	}

	// http://localhost:8080/AppWebBackend/service/stockpool/find/1
	@Path("/find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StockPool find(@PathParam("id") Integer id) {
		return stockPoolDao.getStockPool(id);
	}

}
