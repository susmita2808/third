package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyConnection {

	
public static Connection getConnection() throws SQLException {
	
	
	    Driver driver = new oracle.jdbc.driver.OracleDriver();
		ResourceBundle rb  = ResourceBundle.getBundle("db");		
	    String url = rb.getString("url");
	    String username= rb.getString("username");
	    String password = rb.getString("password");
	    
	    
		return DriverManager.getConnection(url, username, password);
		
	}
}
