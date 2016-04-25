package sandbox;



import java.io.*; 
import java.net.*; 
class ClientNetworking{ 
    public static void main(String argv[]) throws Exception  {
        int sentence;
        int modifiedSentence;
                Socket clientSocket = new Socket("localhost", 6789);   

          DataInputStream inFromUser = new DataInputStream(clientSocket.getInputStream());  
  
          DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());  
          DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());  

        System.out.println("Enter a integer:");
        sentence = inFromUser.readInt(); 
        outToServer.writeInt(sentence);   
        modifiedSentence = inFromServer.readInt();   
        System.out.println("FROM SERVER: " + modifiedSentence);   
        clientSocket.close();  } }
