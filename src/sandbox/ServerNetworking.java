/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.awt.Point;
import java.io.*;
import java.net.*;


class ServerNetworking {
    
    DataOutputStream outToClient;
    String clientCoords;
    String capitalizedSentence;
    
    public static void main(String argv[]) throws Exception {
        
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();
        
        while(true)
        {                       
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());    
                String clientCoords = inFromClient.readLine();  
                System.out.println("Received: " + clientCoords);
                String[] split = clientCoords.split(",");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                Point p = movementPattern(x,y);
                int newX = p.x;
                int newY = p.y;
                String newCoords = newX+","+newY;  
                outToClient.writeBytes(newCoords + '\n');
        }      
    }
    
    public static Point movementPattern(int x, int y)
    {
        if(x >=50 && x <=350 && y == 50){
            x++;
        } 
        if(x == 350 && y >= 50 && y <= 350)
        {
            y++;
        } 
        if(x <= 350 &&  x >= 50 && y == 350)
        {
            x--;
        } 
        if (x == 50 && y <= 350 && y >= 50)
        {
            y--;
        }
        
        return new Point(x,y);
        
    }
} 