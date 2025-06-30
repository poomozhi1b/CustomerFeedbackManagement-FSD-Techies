package Customer_Feedback_Management;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/feedback_db";
    private static final String USER = "root";
    private static final String PASS = "Priya@10";

    public static Connection getConnection1() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}