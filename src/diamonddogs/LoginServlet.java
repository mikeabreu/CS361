package diamonddogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection db = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		try {
			db = DatabaseConnection.getInstance();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
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

		if (auth(request.getParameter("inputUsername"), request.getParameter("inputPassword"))) {
			out.println("<html><body>Successful login! If you aren't redirected shortly click <a href='/DiamondDogs/'>here</a></body></html>");
			Cookie authCookie = new Cookie("username", "Michael");
			response.addCookie(authCookie);
			response.setHeader("Refresh", "20; URL=/DiamondDogs/");
		}
		else {
			out.println("<html><body>Login Attempt Failed! If you aren't redirected shortly click <a href='/DiamondDogs/'>here</a></body></html>");
			response.setHeader("Refresh", "20; URL=/DiamondDogs/");
		}
	}

	private boolean auth(String username, String password) {
		try {
			if (db.query("SELECT user_name, user_pass FROM user WHERE user_name='"+username+"' AND user_pass='" +password+"';")) {
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Couldn't Retreive username and password from DB.");
		}
		
		return false;
	}
}
