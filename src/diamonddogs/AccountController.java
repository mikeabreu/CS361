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
//	private HttpServletRequest request;
	private HttpServletResponse response;
	private Cookie[] raw_cookies;
	private HashMap<String, String> cookies;
	private HashMap<String, String> user;

	/*
	 * Private Constructor
	 */
	private AccountController() {

	}

	public static AccountController getInstance() {
		if (ac == null)
			ac = new AccountController();
		return ac;
	}

	public void sync(HttpServletRequest request, HttpServletResponse response) {
		DatabaseConnection.getInstance();
//		this.request = request;
		this.response = response;
		cookies = new HashMap<String, String>();
		user = new HashMap<String, String>();

		raw_cookies = request.getCookies();
		if (raw_cookies != null) {
			for (Cookie c : raw_cookies) {
				cookies.put(c.getName(), c.getValue());
			}
			if (cookies.containsKey("userid")) {
				if (cookies.get("userid") != "" && cookies.get("userid") != null)
					user = DatabaseConnection.getUser(Integer.parseInt(cookies.get("userid")));
			} else {
				user = new HashMap<String, String>();
			}

		}
	}

	public void check_auth() throws IOException {
		if (!user.containsKey("id")) {
			response.sendRedirect("/DiamondDogs/");
		}
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
}
