import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server is waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            // Input and Output streams
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            // Read message from client
            String clientMessage = input.readLine();

            System.out.println("Message from Client: " + clientMessage);

            // Send reply to client
            output.println("Hello Client, message received!");

            // Close connections
            input.close();
            output.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}