package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task01")
public class Task01 extends HttpServlet {
	private PrintWriter writer;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] parameters = {req.getParameter("nameTask01"), req.getParameter("surname")};
		resp.setContentType("text/html");
		writer = resp.getWriter();
		if (parameters[0].length() == 0 & parameters[1].length() == 0) {
			falseResponse("name, surname");
		} else if(parameters[0].length() == 0) {
			falseResponse("name");
		} else if(parameters[1].length() == 0) {
			falseResponse("surname");
		} else {
			trueResponse(parameters);
		}
	}

	private void trueResponse(String[] parameters) {
		writer.println("<head><style type=\"text/css\"> p { color: green; font-size: 72px; font-family: Aria; " +
				"font-weight: bold; } </style></head><body><p>" + parameters[0] + " " + parameters[1] + "<p/></body>");
	}

	private void falseResponse(String parameter) {
		writer.println("<head><style type=\"text/css\"> p { color: red; font-size: 32px; font-family: Aria; " +
				"font-weight: bold; } </style></head><body><p>Wrong request. <br>Don't exists: " +
				"<span style='color: black;'>" + parameter + "</span><p/></body>");
	}
}
