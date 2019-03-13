/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.requesthandlers;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class FlipRequestHandler extends AbstractRequestHandler {

    

    public FlipRequestHandler(Socket socket) {
        super(socket);
    }
    
   
    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());
        try (Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Type your massage:");
            String flipped = "";
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                
                flipped = flipUpperLower(line);
                writer.println(line + " Changed to: " + flipped);
            }

            System.out.println("RequestHandler DONE!!!!");
        } catch (IOException ex) {
            Logger.getLogger(FlipRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    public String flipUpperLower(String originalString) {
        String flipped = "";
        for (int i = 0; i < originalString.length(); i++) {
            if (Character.isUpperCase(originalString.charAt(i))) {
                flipped += Character.toLowerCase(originalString.charAt(i));
            } else if (Character.isLowerCase(originalString.charAt(i))) {
                flipped += Character.toUpperCase(originalString.charAt(i));
            } else {
                flipped += originalString.charAt(i);
            }
        }

        return flipped;
    }


}
