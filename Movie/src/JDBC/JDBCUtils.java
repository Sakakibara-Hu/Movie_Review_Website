package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/doubanyingp";
	private static String usename = "root";
	private static String password ="123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection Getconnection() {
		try {
			return DriverManager.getConnection(url, usename, password);
		} catch (SQLException e) {
			System.out.println("哎呀，遭求了");
			e.printStackTrace();
		}
		return null;
	}

	public static void free(Connection ct, PreparedStatement st, ResultSet rs) {

		try {
			if (ct != null)
				ct.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
