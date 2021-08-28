package com.service.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.model.Investor;
import com.service.model.Portfolio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PortfolioDao {
	
	private Connection conn = DBConn.conn;
	
	public List<Portfolio> queryAllPortfolio() {
		List<Portfolio> portfolios = new ArrayList<>();
		String sql = "select id, investid, stockpoolid, price, amount, tdate from portfolio";
		try(Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql)) {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer investid = rs.getInt("investid");
				Integer stockpoolid = rs.getInt("stockpoolid");
				Double price = rs.getDouble("price");
				Integer amount = rs.getInt("amount");
				Date tdate = rs.getDate("tdate");
				Portfolio portfolio = new Portfolio(id, investid, stockpoolid, price, amount, tdate);
				portfolios.add(portfolio);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return portfolios;
	}
	
}
