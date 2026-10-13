
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class RideNowServer {

    private static final Path WEB_DIR =
            Path.of("D:/OOPSproject/web").toAbsolutePath();

    public static void main(String[] args) throws Exception {

        System.out.println("Web folder: " + WEB_DIR);
        System.out.println("HTML exists: " +
                Files.exists(WEB_DIR.resolve("index.html")));

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0);

        // Backend test
        server.createContext("/api/hello", exchange -> {
            sendText(exchange, 200,
                    "RideNow Java backend is working!");
        });

        // Booking connection test
        server.createContext("/api/rides", exchange -> {
            if (!exchange.getRequestMethod().equals("POST")) {
                sendText(exchange, 405, "POST required");
                return;
            }

            sendText(exchange, 200,
                    "Ride booking request received by Java backend!");
        });

        // Homepage and frontend files
        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();

            if (path.equals("/")) {
                path = "/index.html";
            }

            if (!path.equals("/index.html")
                    && !path.equals("/style.css")
                    && !path.equals("/app.js")) {
                sendText(exchange, 404, "File not found: " + path);
                return;
            }

            Path file = WEB_DIR.resolve(path.substring(1)).normalize();

            if (!Files.isRegularFile(file)) {
                sendText(exchange, 404,
                        "Missing file: " + file);
                return;
            }

            String type = path.endsWith(".css")
                    ? "text/css; charset=UTF-8"
                    : path.endsWith(".js")
                    ? "application/javascript; charset=UTF-8"
                    : "text/html; charset=UTF-8";

            byte[] data = Files.readAllBytes(file);

            exchange.getResponseHeaders().set("Content-Type", type);
            exchange.sendResponseHeaders(200, data.length);

            try {
                exchange.getResponseBody().write(data);
            } finally {
                exchange.close();
            }
        });

        server.start();
        System.out.println("RideNow running at http://localhost:8080/");
    }

    private static void sendText(
            HttpExchange exchange, int status, String message)
            throws IOException {

        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set(
                "Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(status, data.length);

        try {
            exchange.getResponseBody().write(data);
        } finally {
            exchange.close();
        }
    }
}
