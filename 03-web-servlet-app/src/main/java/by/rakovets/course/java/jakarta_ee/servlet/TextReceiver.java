package by.rakovets.course.java.jakarta_ee.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
