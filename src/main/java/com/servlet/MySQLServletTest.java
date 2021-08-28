package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/mysqltest")
public class MySQLServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("Hello Servlet");
		try {
			// 1. Class.forName
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. dburl, user, password
			String dburl = "jdbc:mysql://localhost:3306/world?zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
			String user = "app";
			String password = "12345678";
			Connection conn = DriverManager.getConnection(dburl, user, password);
			out.println(conn.isClosed());
			Statement stmt = conn.createStatement();
			String sql = "select * from city";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				out.println(id + " : " + name + "<p>");
			}
			
			conn.close();
			out.println(conn.isClosed());
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		
	}
	
}
