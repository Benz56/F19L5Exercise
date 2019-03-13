/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.requesthandlers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class FileOutRequestHandler extends AbstractRequestHandler {

    private final String fileName;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(socket.getInputStream()); PrintWriter writer = new PrintWriter(new FileWriter(fileName, true), true)) {
            writer.append(new Date() + "\t" + socket.getInetAddress() + ":" + socket.getPort() + "\t" + scanner.nextLine() + "\r\n");
        } catch (IOException ex) {
            System.out.println("Something went wrong!");
        }
    }
}
