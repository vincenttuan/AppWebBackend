package com.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/invest?zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
			String user = "app";
			String password = "12345678";
			conn = DriverManager.getConnection(dburl, user, password);	
		} catch (Exception e) {
		}
		
	}
}
