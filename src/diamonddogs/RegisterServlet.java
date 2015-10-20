package diamonddogs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
        super();
        DatabaseConnection.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Variables from POST
        HashMap<String, String> user = new HashMap<>();
        user.put("email", request.getParameter("inputEmail"));
        user.put("name", request.getParameter("inputUsername"));
        user.put("password", request.getParameter("inputPassword"));

        // Create fake credit card, account number and balance.
        Random rng = new Random();
        int cc_num = 0;
        while (cc_num == 0) {
            cc_num = rng.nextInt(10) * 11111111;
        }
        user.put("cc", String.valueOf(cc_num));
        user.put("account", String.valueOf(rng.nextInt(100) * 99));
        user.put("balance", String.valueOf(rng.nextInt(20) * 99));

        // Create SQL Query
        DatabaseConnection.createUser(user);

        // Check if the user was created or not.
        Object[] auth = DatabaseConnection.authenticate(user.get("name"), user.get("password"));
        if ((boolean) auth[0]) {
            Cookie success = new Cookie("success", "true");
            success.setMaxAge(30);
            response.addCookie(success);
        }
        response.sendRedirect("/DD/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/DD/");
    }
}
