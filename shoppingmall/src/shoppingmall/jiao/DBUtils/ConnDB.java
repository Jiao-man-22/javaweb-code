package shoppingmall.jiao.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

public class ConnDB {
	private final String URL = "jdbc:mysql://localhost:3306/mall?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private String username = "root";
	private String password = "123456";
	PreparedStatement pmst = null;
	Connection conn = null;

	// 和数据库建立连接
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 通用数据库连接
	public Connection getAllConn(String url, String databaseName, String databasePwd) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, databaseName, databasePwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Test
	public void function() {
		this.getConn();
	}

}
