package diamonddogs;

import java.sql.*;
import java.util.HashMap;

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
    private DatabaseConnection()
            throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
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
    public static DatabaseConnection getInstance() {
        if (dbc == null) {
            try {
                dbc = new DatabaseConnection();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
                System.err.println("There was an error connecting to the Database.");
            }
        }
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
        Method used to authenticate a user from the DB.
     */
    protected static Object[] authenticate(String username, String password) {
//        PreparedStatement is commented out in replace for createStatment() for SQL Injection purposes.
//        PreparedStatement stmt;
        Object[] result = new Object[2];
        result[0] = false;
        result[1] = -1;
        try {
//            stmt = conn.prepareStatement(
//            "SELECT user_id, user_name, user_pass FROM user WHERE user_name = ? AND user_pass = ?");
//            stmt.setString(1, username);
//            stmt.setString(2, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT user_id, user_name, user_pass FROM user WHERE user_name = "
                    + username + " AND user_pass = " + password + "");

            if (rs.first()) {
                result[0] = rs.first();
                result[1] = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            System.err.println("There was an error while authenticating the user");
        }
        return result;
    }

    /*
        Method used to retrieve HashMap containing all the users information.
     */
    protected static HashMap<String, String> getUser(int user_id) {
        HashMap<String, String> user = new HashMap<>();
        try {
//            PreparedStatement is commented out in replace for createStatment() for SQL Injection purposes.
//            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE user_id = ? ");
//            stmt.setInt(1, user_id);
//            ResultSet rs = stmt.executeQuery();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id = " + user_id);
            while (rs.next()) {
                user.put("id", String.valueOf(rs.getInt("user_id")));
                user.put("name", rs.getString("user_name"));
                user.put("email", rs.getString("user_email"));
                user.put("account", String.valueOf(rs.getInt("user_account")));
                user.put("balance", String.valueOf(rs.getInt("user_balance")));
            }
        } catch (SQLException e) {
            System.err.println("There was an error while retrieving the user information.");
        }
        return user;
    }

    /*
        Method used to create a user in the database.
     */
    protected static boolean createUser(HashMap<String, String> user) {
//        TODO
        return false;
    }
}
