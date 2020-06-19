package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task05")
public class Task05 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("nameTask04");
		String surname = (String) session.getAttribute("surnameTask04");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if (name == null) {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 72px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>Session data is empty<p/></body>");
		} else {
			writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 72px; font-family: Aria; " +
					"font-weight: bold; } </style></head><body><p>" + name + " " + surname + "<p/></body>");
		}
	}
}
