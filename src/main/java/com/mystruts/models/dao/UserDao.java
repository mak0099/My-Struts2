package com.mystruts.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mystruts.connections.OracleCon;
import com.mystruts.models.User;

public class UserDao {
	public static ArrayList<User> search(String term) {
		Connection con = new OracleCon().getCon();
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM USERS " + "WHERE (NAME LIKE ? OR ID LIKE ?) AND delete_datetime IS NULL";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, '%' + term + '%');
			ps.setString(2, '%' + term + '%');
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				userList.add(user);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static ArrayList<User> get() {
		return search("");
	}

	public static ArrayList<User> getUserReport() {
		Connection con = new OracleCon().getCon();
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT p.*, SUM(s.quantity) sales_count\n" + "FROM USERS p \n" + "LEFT JOIN t_sales s \n"
				+ "ON p.ID = s.ID \n" + "WHERE p.delete_datetime IS NULL \n"
				+ "GROUP BY ID";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				userList.add(user);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static void insertUser(User user) {
		Connection con = new OracleCon().getCon();
		try {
			con.setAutoCommit(false);
			String sql1 = "INSERT INTO USERS (ID, PASS, NAME, KANA) values(?,?,?,?)";
			String sql2 = "INSERT INTO USERDETAILS (ID, BIRTH, CLUB) values(?,?,?)";
			try(PreparedStatement ps1 = con.prepareStatement(sql1);
					PreparedStatement ps2 = con.prepareStatement(sql2)) {
				ps1.setString(1, user.getId());
				ps1.setString(2, user.getPassword());
				ps1.setString(3, user.getName());
				ps1.setString(4, user.getNameKatakana());
				ps1.execute();

				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = formatter.parse(user.getDateOfBirth());
				ps2.setString(1, user.getId());
				ps2.setDate(2, new java.sql.Date(dob.getTime()));
				ps2.setString(3, user.getClub());
				ps2.execute();
				
				con.commit();
				ps1.close();
				
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateUser(User user) {
		Connection con = new OracleCon().getCon();
		try {
			String sql = "UPDATE USERS SET NAME = ?, price = ?, update_datetime = CURRENT_TIMESTAMP \n"
					+ "WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteUser(User user) {
		Connection con = new OracleCon().getCon();
		try {
			String sql = "UPDATE USERS SET delete_datetime = CURRENT_TIMESTAMP \n"
					+ "WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static User authenticate(String ID, String PASS) {
		Connection con = new OracleCon().getCon();
		User user = new User();
		try {
			String sql = "SELECT * FROM USERS WHERE ID=? AND PASS=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, PASS);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setNameKatakana(rs.getString("KANA"));
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static User find(String ID) {
		Connection con = new OracleCon().getCon();
		User user = new User();
		try {
			String sql = "SELECT * FROM USERS WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setNameKatakana(rs.getString("KANA"));
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
