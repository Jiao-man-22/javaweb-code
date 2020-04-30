package DBUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//通用的数据库操作方法
/*
 * 工具包将操作数据库代码进行重构 将重复代码提出来，减少代码的冗余，体会到三层的优势
 * 这里  多使用可变参数  使用对像数组进行传参 Object[] params Object[]... params
 * 我这里有点饶了  Object[] params 使用Object... 可以无视参数的类型*/
public  class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/userinfo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static String username="root";
	private static String password="123456";
    static Connection conn = null;
	static PreparedStatement psmt = null;
	boolean flag = false;
	Statement stmt = null;
	ResultSet rs = null;
	// 通用增删改
	public static boolean executeUpdate(String sql, Object[] params) {
			try {
				//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,username,password);
			System.out.println("连接成功");
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

	// 通用的查寻
	public static ResultSet queryExecute(String sql,Object[]... params) {
		ResultSet rs=null;
		try {
			//建立数据库连接
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
