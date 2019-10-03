

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Logout() {
        super();
       }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter pw = response.getWriter();
		pw.print("<center>");
		pw.print("<h2 style='color:blue'>"+"Successfully LoggedOut"+"</h2>");
		pw.print("</center>");
	}

}
