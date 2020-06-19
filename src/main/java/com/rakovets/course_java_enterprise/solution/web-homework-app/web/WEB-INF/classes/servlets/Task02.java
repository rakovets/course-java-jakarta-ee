package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task02")
public class Task02 extends HttpServlet {
	private PrintWriter writer;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String name = req.getParameter("nameTask02");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("mail");
		resp.setContentType("text/html");
		writer = resp.getWriter();

		if (name.length() == 0 || phone.length() == 0 || mail.length() == 0) {
			this.getServletContext()
					.getRequestDispatcher("/task02.jsp")
					.forward(req, resp);
		} else {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>Name: " + name + "<br>Phone: " + phone +
					"<br>Mail: " + mail + "<p/></body>");
		}
	}
}
