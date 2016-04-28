package sandbox;



import java.awt.Point;
import java.io.*; 
import java.net.*; 
import javax.swing.JFrame;
import static sandbox.ServerNetworking.movementPattern;
class ClientNetworking extends JFrame{ 
    
    public static void main(String argv[]) throws Exception  
    {
        JFrame testFrame = new JFrame("Test Frame");
        testFrame.setVisible(true);
        testFrame.setSize(500,500);
        testFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        TestPanel testPanel = new TestPanel();
        testFrame.add(testPanel);
        Point p;
        String coords; 
        String newCoords;  
        //BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in)); 
        Socket clientSocket = new Socket("localhost", 6789);  
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());  
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while(true)
        {
            p = testPanel.getCoords();  
            int x = p.x;
            int y = p.y;
            coords = x+","+y;
            System.out.println(coords);
            outToServer.writeBytes(coords + '\n'); 
            
            newCoords = inFromServer.readLine();
            String[] split = newCoords.split(",");
            int newX = Integer.parseInt(split[0]);
            int newY = Integer.parseInt(split[1]);
            p = new Point(newX, newY);
            
            testPanel.setPlayerLocation(testPanel.getPlayer(), p); 
            testPanel.repaint();
        }  
    } 
}
