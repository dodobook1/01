package com.yxq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	private PreparedStatement pstm;
	private static String user = "root";
	private static String password = "mysql@123.com";
	private static String className = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/javademo?" +
			"user="+user+"&password="+password+"&useUnicode=true&characterEncoding=UTF8";
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	//关闭数据库连接
	public static void close(Connection conn){
		try {
			if(!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("#ERROR#:关闭数据库连接发生异常，请检查！"+e);
		}
	}
}
