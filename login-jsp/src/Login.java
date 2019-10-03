
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static Statement stmnt;
	static HttpSession session;

	public Login() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "kausar", "admin123");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("uid");
		String s2 = request.getParameter("pwd");
				try {
			stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from login where user='" + s1 + "' and password='" + s2 + "'");
			if (rs.next()) {
				session = request.getSession();
				session.setAttribute("a1", s1);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("<p style='color:red'>Invalid Username/Password</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
