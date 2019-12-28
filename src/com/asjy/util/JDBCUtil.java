package com.asjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	//将所有共同的代码提取过来，形成工具类
	public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动路径
	public static final String URL = "jdbc:mysql://localhost:3306/mysql1820y";//数据库路径
	public static final String USER = "root";//用户名
	public static final String PASSWORD = "root";//密码
	
	//提取前两步代码
	public static Connection getConnection() {
		//不能光封装前两行代码，还得将conn当作返回值返回
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//提取关闭资源的代码
	public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
		//校验：参数的非空性
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}






