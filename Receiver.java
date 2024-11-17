import java.io.*;
import java.net.*;

public class Receiver {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;

    public Receiver(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void listenForMessages() throws IOException {
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received message: " + message);
        }
    }

    public void close() throws IOException {
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
