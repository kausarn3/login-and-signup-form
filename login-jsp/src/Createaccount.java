
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Createaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static Statement stmnt;
	static ResultSet rs;
	static PreparedStatement ps;

	public Createaccount() {
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

			ps = conn.prepareStatement("insert into login values(?,?)");

			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.executeUpdate();
			ps.close();
			
			stmnt = conn.createStatement();
			ps=conn.prepareStatement("select * from login where user='" + s1 + "'");
			rs=ps.executeQuery();	
			
			if (rs.next()) {
			
			final String fromEmail = "123salmankhan678@gmail.com";
				final String password = "Salman@123";
				final String toMail = "kausarnazir1@gmail.com";

				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true");

				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};

				Session session = Session.getInstance(prop, auth);
				MimeMessage m = new MimeMessage(session);
				m.setFrom(new InternetAddress(fromEmail));
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
				System.out.println("mail check");
				m.setSubject("your username and password");
				m.setText("username:'" + s1 + "' and password:'" + s2 + "'");
				System.out.println("mail check 1");
				Transport.send(m);
				System.out.println("message sent successfully");

				PrintWriter pw = response.getWriter();
				pw.print("<script>window.history.forward();</script>");
				pw.print("<center>");
				pw.print("<form action='login.jsp' method='post'>");
				pw.print("<p>" + "THANKS FOR REGISTRATION" + "</p>");
				pw.print("<p2>" + "YOUR USERNAME IS:" + s1 + "</p>");
				pw.print("Click Here To Login" + "<input type='submit' value='Login'>");
				pw.print("</form>");
				pw.print("</center>");
			}

		} catch (SQLException | MessagingException e) {
			e.printStackTrace();
			PrintWriter pw = response.getWriter();
			pw.println("<p style='color:red'>Username already exist</p>");
			RequestDispatcher rd = request.getRequestDispatcher("createaccount.jsp");
			rd.include(request, response);
		}

		
	}
	}

