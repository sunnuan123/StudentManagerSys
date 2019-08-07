package com.rgzn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * JDBC�Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class DBUtil {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static  ResultSet  rs=null;
	
	/**
	 * ����һ������* 
	 * @return
	 */
	public static Connection getConnection() {		
		try {
			
		    /***Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��ȡ����
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "bjsxt", "bjsxt");
			***/
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			
			conn = DriverManager.getConnection("proxool.test");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * �ر����ݿ���Դ
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * ִ��insert��update��delete ����DML����
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] params) {
		
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * ִ�в�ѯ�����ص�Resultset����
	 **/
	
	public static ResultSet executeQuery (String sql, Object[] params) {
		
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			
			    rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
}
