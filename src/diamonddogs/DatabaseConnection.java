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
        Object[] result = new Object[2];
        result[0] = false;
        result[1] = -1;
        try {
            /* Vulnerable Code */
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT user_id, user_name, user_pass FROM user WHERE user_name = '"
//                    + username + "' AND user_pass = '" + password + "'");

            /* More Secure Code */
            PreparedStatement stmt = conn.prepareStatement("SELECT user_id, user_name, user_pass FROM user WHERE " +
                    "user_name=? AND user_pass =?");
            stmt.setString(1, validate(username));
            stmt.setString(2, validate(password));
            ResultSet rs = stmt.executeQuery();
            /* End Secure Code Addition */

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
            /* Vulnerable Code */
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id = '" + user_id + "'");

            /* More Secure Code */
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            stmt.setInt(1, validate(user_id));
            ResultSet rs = stmt.executeQuery();
            /* End Secure Code Addition */

            while (rs.next()) {
                user.put("id", String.valueOf(rs.getInt("user_id")));
                user.put("name", rs.getString("user_name"));
                user.put("email", rs.getString("user_email"));
                user.put("account", String.valueOf(rs.getInt("user_account")));
                user.put("balance", String.valueOf(rs.getInt("user_balance")));
                user.put("cc", String.valueOf(rs.getInt("user_cc")));
            }
        } catch (SQLException e) {
            System.err.println("There was an error while retrieving the user information.");
        }
        return user;
    }

    /*
        Method used to create a user in the database.

        user:   name        =   user_name
                password    =   user_password
                email       =   user_email
                cc          =   user_cc
                account     =   user_account
                balance     =   user_balance
     */
    protected static void createUser(HashMap<String, String> user) {
        try {
            /* Vulnerable Code */
//            Statement stmt = conn.createStatement();
//            String query = "INSERT INTO diamonddog.user (user_name, user_email, user_cc, user_pass, user_account, user_balance) "
//                    + "VALUES ('"
//                    + user.get("name") + "', '"
//                    + user.get("email") + "', '"
//                    + user.get("cc") + "', '"
//                    + user.get("password") + "', '"
//                    + user.get("account") + "', '"
//                    + user.get("balance") + "');";
//            stmt.executeUpdate(query);

            /* More Secure Code */
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO diamonddog.user (user_name, user_email, user_cc, user_pass, user_account, user_balance) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, validate(user.get("name"))); // user_name
            stmt.setString(2, validate(user.get("email"))); // user_email
            stmt.setString(3, validate(user.get("cc"))); // user_cc
            stmt.setString(4, validate(user.get("pass"))); // user_pass
            stmt.setString(5, validate(user.get("account"))); // user_account
            stmt.setString(6, validate(user.get("balance"))); // user_balance
            stmt.executeUpdate();
            conn.commit();
            /* End Secure Code Addition */
            return;
        } catch (SQLException e) {
            System.err.println("Unable to create the new user.");
        }
        return;
    }

    private static String validate(String bad_text) {
        // String validation code here
        String safe_text = bad_text;

        // Remove: -
        safe_text = safe_text.replace('-', ' ');
        // Remove: '
        safe_text = safe_text.replace('\'', ' ');
        // Remove: "
        safe_text = safe_text.replace('"', ' ');
        // Remove: )
        safe_text = safe_text.replace(')', ' ');
        // Remove: (
        safe_text = safe_text.replace('(', ' ');
        // Remove: }
        safe_text = safe_text.replace(')', ' ');
        // Remove: {
        safe_text = safe_text.replace('(', ' ');
        // Remove: ~
        safe_text = safe_text.replace('~', ' ');
        // Remove: {
        safe_text = safe_text.replace('{', ' ');
        // Remove: }
        safe_text = safe_text.replace('}', ' ');

        return safe_text;
    }

    private static int validate(int num) {
        if (num <= 0) {
            return -1;
        } else if (num >= 2000000) {
            return 2000000;
        } else
            return num;
    }
}
