import java.io.*;
import java.net.*;

public class Sender {
    private Socket socket;
    private PrintWriter out;

    public Sender(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }
}
