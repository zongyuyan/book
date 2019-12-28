package com.asjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asjy.util.JDBCUtil;

public class BookDao {

	//压缩增删改的代码
	public static boolean update(String sql, Object...obj) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstm = null;
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			//动态给问号赋值！
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, null);
		}
		return result > 0 ? true : false;
	}
}
