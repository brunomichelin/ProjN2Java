package principal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;

		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://DESKTOP-4MHF9P8\\SQLEXPRESS;Database=DB_MECANICO";
			String user = "sa";
			String password = "1q2w3e4r5t6y";

			Class.forName(driver); // Verifica se o driver esta no CLASSPATH

			connection = DriverManager.getConnection(url, user, password);

			connection.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}
