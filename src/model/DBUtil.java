package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/ssafy_8th";
	private static final String dbUser = "ssafy";
	private static final String dbPw = "ssafy";
	
	static {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩완료");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		}
	}
	static Connection makeConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,dbUser,dbPw);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return conn;
	}
	static void close(AutoCloseable... closeables) {
		for(AutoCloseable c : closeables) {
			if(c != null) {
				try {
					c.close();
				}catch(Exception e) {
					
				}
				
			}
		}
	}
}
