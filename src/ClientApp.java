import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        String host = "localhost"; // или "127.0.0.1"
        int port = 8080;

        try {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Alice");

            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}