package com.asjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	//�����й�ͬ�Ĵ�����ȡ�������γɹ�����
	public static final String DRIVER = "com.mysql.jdbc.Driver";//����·��
	public static final String URL = "jdbc:mysql://localhost:3306/mysql1820y";//���ݿ�·��
	public static final String USER = "root";//�û���
	public static final String PASSWORD = "root";//����
	
	//��ȡǰ��������
	public static Connection getConnection() {
		//���ܹ��װǰ���д��룬���ý�conn��������ֵ����
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
	
	//��ȡ�ر���Դ�Ĵ���
	public static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
		//У�飺�����ķǿ���
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






