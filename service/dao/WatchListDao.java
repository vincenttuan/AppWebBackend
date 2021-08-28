package com.service.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.model.Investor;
import com.service.model.Portfolio;
import com.service.model.TransactionLog;
import com.service.model.WatchList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class WatchListDao {
	
	private Connection conn = DBConn.conn;
	
	public List<WatchList> queryAllWatchList() {
		List<WatchList> watchLists = new ArrayList<>();
		String sql = "select id, investid, stockpoolid, tdate from watchlist";
		try(Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql)) {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer investid = rs.getInt("investid");
				Integer stockpoolid = rs.getInt("stockpoolid");
				Date tdate = rs.getDate("tdate");
				WatchList watchlist = new WatchList(id, investid, stockpoolid, tdate);
				watchLists.add(watchlist);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return watchLists;
	}
	
	public List<WatchList> queryByInvestorId(Integer investorId) {
		List<WatchList> watchLists = new ArrayList<>();
		String sql = "select id, investid, stockpoolid, tdate from watchlist where investid=" + investorId;
		try(Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql)) {
			while(rs.next()) {
				Integer id = rs.getInt("id");
				Integer investid = rs.getInt("investid");
				Integer stockpoolid = rs.getInt("stockpoolid");
				Date tdate = rs.getDate("tdate");
				WatchList watchlist = new WatchList(id, investid, stockpoolid, tdate);
				watchLists.add(watchlist);
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return watchLists;
	}
	
}
