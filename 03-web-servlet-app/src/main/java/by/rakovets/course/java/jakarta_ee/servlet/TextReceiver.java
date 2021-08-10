package by.rakovets.course.java.jakarta_ee.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/text")
public class TextReceiver extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        String resultText = "";
        String currentLine;
        do {
            currentLine = reader.readLine();
            if (currentLine != null) {
                resultText += currentLine + "\n";
            }
        } while (currentLine != null);
        System.out.println(resultText);
    }
}
