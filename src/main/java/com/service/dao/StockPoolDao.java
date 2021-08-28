package com.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.model.StockPool;

public class StockPoolDao {
	
	private Connection conn = DBConn.conn;
	
	public StockPool getStockPool(Integer stockPoolId) {
		StockPool stockPool= null;
		String sql = "select id, typeid, symbol, symbolname, warning, tdate from stockpool where id=?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, stockPoolId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Integer id = rs.getInt("id");
				Integer typeid = rs.getInt("typeid");
				String symbol = rs.getString("symbol");
				String symbolname = rs.getString("symbolname");
				Integer warning = rs.getInt("warning");
				Date tdate = rs.getDate("tdate");
				stockPool = new StockPool(id, typeid, symbol, symbolname, warning, tdate);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return stockPool;
	}
	
	public List<StockPool> queryAllStockPool() {
		List<StockPool> stockPools = new ArrayList<>();
		String sql = "select id, typeid, symbol, symbolname, warning, tdate from stockpool";
		try(Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql)) {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer typeid = rs.getInt("typeid");
				String symbol = rs.getString("symbol");
				String symbolname = rs.getString("symbolname");
				Integer warning = rs.getInt("warning");
				Date tdate = rs.getDate("tdate");
				StockPool stockPool = new StockPool(id, typeid, symbol, symbolname, warning, tdate);
				stockPools.add(stockPool);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return stockPools;
	}
}
