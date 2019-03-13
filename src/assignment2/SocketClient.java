package assignment2;

import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 3333); Scanner keyboard = new Scanner(System.in);
                PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream(), true)) {
            outputStream.println(keyboard.nextLine());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
