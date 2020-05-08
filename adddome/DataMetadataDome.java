package DBUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/** Ԫ���ݣ��������ݵ�����
���ࣺ
���ݿ�Ԫ���� ,����Ԫ���� �������Ԫ����
1.���ݿ�Ԫ����  DataBaseMetaData
2�Ͳ����йص�   ParameterMeterData
3�����Ԫ����   ResultSetMeterData 
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
			//��ȡ���ݿ�Ԫ����
			metaData = conn.getMetaData();
			String databaseProductName = metaData.getDatabaseProductName();
			userName2 = metaData.getUserName();
			System.out.println(userName2);
			System.out.println(databaseProductName);
			//�Բ������в���
			//String sql="select *from userdata where name=?and pwd=?";
			String sql="select *from userdata";
			prepareStatement = conn.prepareStatement(sql);
			//ʹ��ParameterMetaData����.��ռλ�����б���
			ParameterMetaData parameterMetaData = prepareStatement.getParameterMetaData();
			int parameterCount = parameterMetaData .getParameterCount();
			System.out.println(parameterCount);
			for(int i=1;i<=parameterCount;i++) {
				System.out.println(parameterMetaData.getParameterTypeName(i));
			}
			//�����Ԫ����
			ResultSet rs = prepareStatement.executeQuery();
			//��ý����Ԫ����
			ResultSetMetaData metaData2 = rs.getMetaData();
			System.out.println(metaData2.getColumnCount());
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
