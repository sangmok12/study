package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnect {
	
	public static Connection Connection() throws Exception {
	//  DB 접속  
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "c##java";
		String userpass = "1234";

	//  드라이버(ojdbc6.jar) 연결
		Class.forName("oracle.jdbc.OracleDriver");
	//  DB 접속
		Connection con = DriverManager.getConnection(url,username,userpass);
		return con;

	}
}
