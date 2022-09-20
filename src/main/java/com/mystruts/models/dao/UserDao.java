package com.mystruts.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mystruts.connections.OracleCon;
import com.mystruts.models.User;

public class UserDao {
	public static ArrayList<User> search(String id, String name, String kana) {
		Connection con = new OracleCon().getCon();
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM USERS u LEFT JOIN USERDETAILS ud ON u.ID=ud.ID WHERE (u.ID LIKE ? OR u.NAME LIKE ? OR u.KANA LIKE ?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id!=null && id.length()>0 ? '%' + id + '%' : null);
			ps.setString(2, name!=null && name.length()>0 ? '%' + name + '%' : null);
			ps.setString(3, kana!=null && kana.length()>0 ? '%' + kana + '%' : null);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setKana(rs.getString("KANA"));
				user.setDateOfBirth(rs.getTimestamp("BIRTH"));
				user.setClub(rs.getString("CLUB"));
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

	public static void insertUser(User user) throws Exception {
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
				ps1.setString(4, user.getKana());
				ps1.execute();

				ps2.setString(1, user.getId());
				ps2.setDate(2, new java.sql.Date(user.getDateOfBirth().getTime()));
				ps2.setString(3, user.getClub());
				ps2.execute();
				
				con.commit();
				ps1.close();
				
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void updateUser(User user) throws Exception {
		Connection con = new OracleCon().getCon();
		try {
			con.setAutoCommit(false);
			String sql1 = "UPDATE USERS SET NAME = ?, KANA = ? WHERE ID = ?";
			String sql2 = "UPDATE USERDETAILS SET BIRTH = ?, CLUB = ? WHERE ID = ?";
			try(PreparedStatement ps1 = con.prepareStatement(sql1);
					PreparedStatement ps2 = con.prepareStatement(sql2)) {
				ps1.setString(1, user.getName());
				ps1.setString(2, user.getKana());
				ps1.setString(3, user.getId());
				ps1.execute();

				ps2.setDate(1, new java.sql.Date(user.getDateOfBirth().getTime()));
				ps2.setString(2, user.getClub());
				ps2.setString(3, user.getId());
				ps2.execute();
				
				con.commit();
				ps1.close();
				
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void deleteUser(User user) throws Exception {
		Connection con = new OracleCon().getCon();
		try {
			con.setAutoCommit(false);
			String sql1 = "DELETE USERS WHERE ID = ?";
			String sql2 = "DELETE USERDETAILS WHERE ID = ?";
			try(PreparedStatement ps1 = con.prepareStatement(sql1);
					PreparedStatement ps2 = con.prepareStatement(sql2)) {
				ps1.setString(1, user.getId());
				ps1.execute();
				
				ps2.setString(1, user.getId());
				ps2.execute();
				
				con.commit();
				ps1.close();
				
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
				throw e;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
			user.setKana(rs.getString("KANA"));
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
			String sql = "SELECT * FROM USERS u LEFT JOIN USERDETAILS ud ON u.ID=ud.ID WHERE u.ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setPassword(rs.getString("PASS"));
			user.setKana(rs.getString("KANA"));
			user.setDateOfBirth(rs.getTimestamp("BIRTH"));
			user.setClub(rs.getString("CLUB"));
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
