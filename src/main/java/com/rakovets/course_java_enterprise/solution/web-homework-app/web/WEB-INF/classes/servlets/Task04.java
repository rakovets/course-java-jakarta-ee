package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/task04")
public class Task04 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("nameTask04");
		String surname = req.getParameter("surnameTask04");
		HttpSession session = req.getSession();
		session.setAttribute("nameTask04", name);
		session.setAttribute("surnameTask04", surname);
	}
}
