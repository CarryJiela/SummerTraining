/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DataBaseConnectionMap {
    // 定义了MySQL数据库的驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 定义了MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://118.89.161.52:3306/WeShare";
	public static final String DBUSER = "WJW";
	public static final String DBPASS = "123456";

	static Connection conn = null;
	public DataBaseConnectionMap() throws Exception{
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}
	}

	public  Connection getConnection() {

		return this.conn;
	}
	public  void closeConnection() throws Exception{
		try {
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}
}
