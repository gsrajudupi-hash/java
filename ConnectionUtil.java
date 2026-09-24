package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Author   : rajgs
 * Date     : 24 Sept 2026
 * Time     : 3:52:04 pm
 * Project  : AdvancedJava
 */

public class ConnectionUtil {
	
	public static Connection createConnection() throws Exception 
	{
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","redhat");
		return con;
	}

}
