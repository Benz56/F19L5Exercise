package assignment2;

import assignment1.saviich_10_9.Species;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientObject {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 3333);
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
            outputStream.writeObject(new Species("Jan", 10, 20));
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
