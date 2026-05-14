import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket socket = new Socket("127.0.0.1", 5000);

            // Input and Output streams
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Take message from user
            System.out.print("Enter message: ");
            String message = userInput.readLine();

            // Send message to server
            output.println(message);

            // Receive reply from server
            String serverReply = input.readLine();

            System.out.println("Server Reply: " + serverReply);

            // Close connections
            input.close();
            output.close();
            userInput.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}