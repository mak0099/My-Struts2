package com.mystruts.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleCon {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String driver = "oracle.jdbc.OracleDriver";
	public String user = "system";
	public String password = "khan";

	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
