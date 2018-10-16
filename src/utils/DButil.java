package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DButil {
	private static String driverClass;
	private static String URL;
	private static String username;
	private static String password;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("DBinfo");
		//自动加载资源文件   加载properties文件
		
		driverClass=rb.getString("driverClass");
		URL=rb.getString("URL");
		username=rb.getString("username");
		password=rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{				
		return DriverManager.getConnection(URL, username, password);  
		//解耦合		
	}
	
	public static void closeAll(ResultSet rs,Statement s,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		if(s!=null){
			try {
				s.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
		}
	}
}
