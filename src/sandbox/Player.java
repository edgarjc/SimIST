/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.awt.*;

/**
 *
 * @author kjrya
 */
public class Player extends Rectangle {
    
    Color playerColor;
    
    public Player(int a, int b, int c, int d, Color color){
        x = a;
        y = b;
        width = c;
        height = d;
        playerColor = color;
    }
    
    public Color getColor(){
        return this.playerColor;
    }
    
    public void paintPlayer(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(playerColor);
        g.fillRect(x, y, width, height);
    }
    
}
