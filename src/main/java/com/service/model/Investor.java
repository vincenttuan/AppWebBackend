package com.service.model;

import java.util.Date;
import java.util.List;

public class Investor {
	// -- ����� ----------------
	private Integer id;
	private String username;
	private String email;
	private Date tdate;
	
	//-- ���p��� -----------------
	private List<TransactionLog> transactionLogs;
	private List<WatchList> watchLists;
	
	public Investor() {
		
	}
	
	public Investor(Integer id, String username, String email, Date tdate) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.tdate = tdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
	
	
	public List<TransactionLog> getTransactionLogs() {
		return transactionLogs;
	}

	public void setTransactionLogs(List<TransactionLog> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	public List<WatchList> getWatchLists() {
		return watchLists;
	}

	public void setWatchLists(List<WatchList> watchLists) {
		this.watchLists = watchLists;
	}

	@Override
	public String toString() {
		return "Investor [id=" + id + ", username=" + username + ", email=" + email + ", tdate=" + tdate + "]";
	}
	
	
	
	
}
