package main.java.com.rakovets.course_java_enterprise.solution;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SendNameAndSurname {
    public static void main(String[] args) throws IOException {
        String urlParameters = "param1=a&param2=c";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        String request = "http://localhost:8080";
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        Methods methods = new Methods();
        String setName = methods.askName();
        String setSername = methods.askSurname();
        conn.setRequestProperty("Add Name", setName);
        conn.setRequestProperty("Add Surname", setSername);
        conn.setUseCaches(false);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }
    }
}
