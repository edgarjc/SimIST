/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.*;
import java.net.*;
class ServerNetworking {
    public static void main(String argv[]) throws Exception {
        int clientSentence=0;
        int capitalizedSentence=0;
        ServerSocket welcomeSocket = new ServerSocket(6789);
       try{
           Socket connectionSocket = welcomeSocket.accept(); 

            DataInputStream inFromClient= new DataInputStream(connectionSocket.getInputStream());  
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        while(true){                    
            clientSentence = inFromClient.readInt();
            System.out.println("Received: " + clientSentence);
           // capitalizedSentence = clientSentence;  
            outToClient.writeInt(capitalizedSentence);
        }      
       }catch(Exception E){}
       
    } } 