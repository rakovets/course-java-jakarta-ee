package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task04")
public class Task04 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String entityID = req.getParameter("entityID");
//		int id = Integer.parseInt(entityID);
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<head><style type=\"text/css\"> p { color: green; font-size: 27px; font-family: Aria; " +
				"font-weight: bold; } </style></head><body><p>Id: " + entityID + "<br>Task04 in development!!!<p/>" +
				"</body>");
	}
}