package DBUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/** 元数据：描述数据的数据
三类：
数据库元数据 ,参数元数据 ，结果集元数据
1.数据库元数据  DataBaseMetaData
2和参数有关的   ParameterMeterData
3结果集元数据   ResultSetMeterData 
*/
public class DataMetadataDome {
	private static String URL="jdbc:mysql://localhost:3306/userinfo?generateSimpleParameterMetadata=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static String username="root";
	private static String password="123456";
	private static DatabaseMetaData metaData;
	private static String userName2;
	private static PreparedStatement prepareStatement;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,username,password);
			//获取数据库元数据
			metaData = conn.getMetaData();
			String databaseProductName = metaData.getDatabaseProductName();
			userName2 = metaData.getUserName();
			System.out.println(userName2);
			System.out.println(databaseProductName);
			//对参数进行操作
			//String sql="select *from userdata where name=?and pwd=?";
			String sql="select *from userdata";
			prepareStatement = conn.prepareStatement(sql);
			//使用ParameterMetaData对象.对占位符进行遍历
			ParameterMetaData parameterMetaData = prepareStatement.getParameterMetaData();
			int parameterCount = parameterMetaData .getParameterCount();
			System.out.println(parameterCount);
			for(int i=1;i<=parameterCount;i++) {
				System.out.println(parameterMetaData.getParameterTypeName(i));
			}
			//结果集元数据
			ResultSet rs = prepareStatement.executeQuery();
			//获得结果集元数据
			ResultSetMetaData metaData2 = rs.getMetaData();
			System.out.println(metaData2.getColumnCount());
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
