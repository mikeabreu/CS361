package diamonddogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Database Connection Object uses JDBC
 * 
 * Singleton Design Pattern
 */
public class DatabaseConnection {

	private static DatabaseConnection dbc;
	private static Connection conn;

	/*
	 * Private Constructor used to setup the DatabaseConnection Object
	 */
	private DatabaseConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String[] dbCreds = getCredientials();
		String connectionURL = dbCreds[0];
		String username = dbCreds[1];
		String password = dbCreds[2];
		conn = DriverManager.getConnection(connectionURL, username, password);
	}

	/*
	 * Method used to retrieve DatabaseConnection Object
	 */
	public static DatabaseConnection getInstance() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (dbc == null)
			dbc = new DatabaseConnection();
		return dbc;
	}

	/*
	 * Private Method used to grab username and password from Operating System
	 * Environment Variables
	 */
	private String[] getCredientials() {
		String[] dbCreds = new String[3];

		// CONNECTION
		if (System.getenv("DB_CONNECTION") != null)
			dbCreds[0] = System.getenv("DB_CONNECTION");
		else
			dbCreds[0] = "jdbc:mysql://localhost:3306/diamonddog";
		
		// USERNAME
		if (System.getenv("DB_USERNAME") != null)
			dbCreds[1] = System.getenv("DB_USERNAME");
		else
			dbCreds[1] = "diamonddog";
		
		// PASSWORD
		if (System.getenv("DB_PASSWORD") != null)
			dbCreds[2] = System.getenv("DB_PASSWORD");
		else
			dbCreds[2] = "diamonddog";
		
		return dbCreds;
	}

	/*
	 * Private Method used to send a SQL Query
	 */
	private ResultSet query(String query) throws SQLException {
		query = sanitizeQuery(query);
		Statement stmt = conn.createStatement();
		System.out.println("Query: " + query);
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	/*
	 * Private Method used to sanitize the input of a SQL Query
	 */
	private String sanitizeQuery(String query) {
		return query;
	}
	
	public static void main(String[] args) {
		try {
			DatabaseConnection db = DatabaseConnection.getInstance();
			
			ResultSet rs = db.query("SELECT * FROM user");
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("user_pass"));
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
