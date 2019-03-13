/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.tcp_server_runnable;

import assignment2.requesthandlers.ObjectRequestHandler;
import assignment2.requesthandlers.AbstractRequestHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author erso
 */
public class TCPServer {

    private final int port;
    private AbstractRequestHandler requestHandler;

    public TCPServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                System.out.println("Server waiting....");
                Socket socket = ss.accept();
                System.out.println("Server has accepted a client on port " + socket.getPort());

                //Choose RequestHandler before start:
                //requestHandler = new FlipRequestHandler(socket);
                //requestHandler = new FileOutRequestHandler(socket, "RequestLog.txt");
                requestHandler = new ObjectRequestHandler(socket);

                new Thread(requestHandler).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TCPServer(3333).start();
    }
}
