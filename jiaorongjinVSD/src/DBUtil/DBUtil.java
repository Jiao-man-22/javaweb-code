package DBUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//ͨ�õ����ݿ��������
/*
 * ���߰����������ݿ��������ع� ���ظ���������������ٴ�������࣬��ᵽ���������
 * ����  ��ʹ�ÿɱ����  ʹ�ö���������д��� Object[] params Object[]... params
 * �������е�����  Object[] params ʹ��Object... �������Ӳ���������*/
public  class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/userinfo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static String username="root";
	private static String password="123456";
    static Connection conn = null;
	static PreparedStatement psmt = null;
	boolean flag = false;
	Statement stmt = null;
	ResultSet rs = null;
	// ͨ����ɾ��
	public static boolean executeUpdate(String sql, Object[] params) {
			try {
				//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,username,password);
			System.out.println("���ӳɹ�");
			psmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i + 1, params[i]);
			}
			psmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	// ͨ�õĲ�Ѱ
	public static ResultSet queryExecute(String sql,Object[]... params) {
		ResultSet rs=null;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,username,password);
			psmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i+1,params[i]);
			}
			rs = psmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}
}
