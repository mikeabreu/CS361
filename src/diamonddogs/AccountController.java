package diamonddogs;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * AccountController Object to handle any account actions
 */
public class AccountController {
    protected static AccountController ac;
    private HashMap<String, String> user;
    private boolean authenticated = false;

    /*
     * Private Constructor
     */
    private AccountController() {
        DatabaseConnection.getInstance();
    }

    public static AccountController getInstance() {
        if (ac == null)
            ac = new AccountController();
        return ac;
    }

    public void sync(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> cookies = new HashMap<>();
        user = new HashMap<>();

        Cookie[] raw_cookies = request.getCookies();
        if (raw_cookies != null) {
            for (Cookie c : raw_cookies) {
                cookies.put(c.getName(), c.getValue());
            }
            if (cookies.containsKey("userid")) {
                if (!cookies.get("userid").equals("") && cookies.get("userid") != null) {
                    user = DatabaseConnection.getUser(Integer.parseInt(cookies.get("userid")));
                }
            } else {
                user = new HashMap<>();
            }
        }
    }

    public void check_auth(HttpServletResponse response) throws IOException {
        if (!user.containsKey("id")) {
            authenticated = false;
            response.setHeader("Refresh", "3; URL=/DD/");
        } else {
            authenticated = true;
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String display_username() {
        if (user.containsKey("name"))
            return user.get("name");
        return "NO NAME";
    }

    public String display_email() {
        if (user.containsKey("email"))
            return user.get("email");
        return "NO EMAIL";
    }

    public String display_account() {
        if (user.containsKey("account"))
            return user.get("account");
        return "NO ACCOUNT";
    }

    public String display_balance() {
        if (user.containsKey("balance"))
            return user.get("balance");
        return "NO BALANCE";
    }

    public String display_cc() {
        if (user.containsKey("cc"))
            return user.get("cc");
        return "NO CREDIT CARD";
    }
}
