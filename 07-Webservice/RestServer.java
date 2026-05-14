import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class RestServer {

    public static void main(String[] args) throws Exception {

        // Create server on port 8000
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8000), 0);

        // Create endpoint
        server.createContext("/hello", (HttpExchange exchange) -> {

            String response =
                    "Hello from Java Web Service";

            exchange.sendResponseHeaders(
                    200,
                    response.length());

            OutputStream os =
                    exchange.getResponseBody();

            os.write(response.getBytes());

            os.close();
        });

        server.setExecutor(null);

        server.start();

        System.out.println(
                "Web Service Started at http://localhost:8000/hello");
    }
}