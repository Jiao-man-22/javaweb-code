package jiaorongjinVSD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnDB {
	private final String URL="jdbc:mysql://localhost:3306/userinfo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private String username="root";
	private String password="123456";
	PreparedStatement pmst=null;
	Connection conn=null;
	//和数据库建立连接
	public Connection getConn() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,username,password);
			System.out.println("连接成功");
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
