/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.requesthandlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author bemma_000
 */
public class ObjectRequestHandler extends AbstractRequestHandler {

    public ObjectRequestHandler(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            System.out.println(inputStream.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Something went wrong!");
        }
    }
}
