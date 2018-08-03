package com.bdi.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBTest {

	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://localhost:3306/dbi";
	private static String id = "root";
	private static String pwd = "12345678";
	public static void main(String[] args) {
		Connection con = null;
		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			Statement stmt = con.createStatement();
			String sql = "select * from user_info";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Map<String,String> user = new HashMap<String,String>();
				user.put("uiNo", rs.getString("uiNo"));
				user.put("uiId", rs.getString("uiId"));
				user.put("uiPwd", rs.getString("uiPwd"));
				user.put("uiName", rs.getString("uiName"));
				userList.add(user);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userList);
	}
}
