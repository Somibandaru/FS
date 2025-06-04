package LoginServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import com.sun.net.httpserver.*;

public class SimpleHttpLogin {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/login", new LoginHandler());
        server.setExecutor(null);
        System.out.println("Server started on port 8000");
        server.start();
    }
}

class LoginHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        // Allow only POST
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            String response = "Only POST method is supported";
            exchange.sendResponseHeaders(405, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return;
        }

        // Read body
        BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8));
        String formData = reader.readLine(); // e.g., username=admin&password=admin

        String username = "";
        String password = "";

        // Parse form-encoded data safely
        if (formData != null) {
            for (String pair : formData.split("&")) {
                String[] keyValue = pair.split("=", 2);
                if (keyValue.length == 2) {
                    String key = URLDecoder.decode(keyValue[0], "UTF-8");
                    String value = URLDecoder.decode(keyValue[1], "UTF-8");
                    if (key.equals("username")) {
                        username = value;
                    } else if (key.equals("password")) {
                        password = value;
                    }
                }
            }
        }

        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            String response = "Invalid credentials";
            exchange.sendResponseHeaders(401, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return;
        }

        // Validate user from DB
        boolean isValid = validateCredentials(username, password);

        String response = isValid ? "Login successful" : "Invalid credentials";
        int statusCode = isValid ? 200 : 401;

        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private boolean validateCredentials(String username, String password) {
        try {
            // Adjust DB credentials as per your setup
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/restdb", "root", "<your sql pass here"
            );

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();

            rs.close();
            stmt.close();
            conn.close();

            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
