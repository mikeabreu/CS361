package diamonddogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		DatabaseConnection.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/DiamondDogs/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int userid = 0;
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		Object[] auth = DatabaseConnection.authenticate(username, password);
		if ((boolean) auth[0]) {
			userid = (int) auth[1];
			out.println(
					"<html><body>Successful login! If you aren't redirected shortly click <a href='/DiamondDogs/account'>here</a></body></html>");
			HashMap<String, String> user = DatabaseConnection.getUser(userid);
			Cookie cUserID = new Cookie("userid", user.get("id"));
			Cookie cUserName = new Cookie("username", user.get("name"));
			Cookie cUserEmail = new Cookie("email", user.get("email"));
			Cookie cUserAccount = new Cookie("account", user.get("account"));
			Cookie cUserBalance = new Cookie("balance", user.get("balance"));
			cUserID.setMaxAge(120);
			cUserName.setMaxAge(120);
			cUserEmail.setMaxAge(120);
			cUserAccount.setMaxAge(120);
			cUserBalance.setMaxAge(120);
			response.addCookie(cUserID);
			response.addCookie(cUserName);
			response.addCookie(cUserEmail);
			response.addCookie(cUserAccount);
			response.addCookie(cUserBalance);
			response.setHeader("Refresh", "5; URL=/DiamondDogs/account");
		} else {
			out.println(
					"<html><body>Login Attempt Failed! If you aren't redirected shortly click <a href='/DiamondDogs/'>here</a></body></html>");
			response.setHeader("Refresh", "5; URL=/DiamondDogs/");
		}
	}

}
