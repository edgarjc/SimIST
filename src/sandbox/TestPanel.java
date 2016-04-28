/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author kjrya
 */
public class TestPanel extends JPanel implements ActionListener
{
    
    Player p;
    Timer moveTimer;
    
    public TestPanel()
    {
        this.setSize(400,400);        
        this.setVisible(true);
        moveTimer = new Timer(10, this);
        moveTimer.start();
        p = new Player(50, 50, 20, 20, Color.blue);
    }
    
    
    protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            setBackground(Color.GRAY);
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(p.getColor());
            g.fillRect(p.x, p.y, 50, 50);
        }
    
    
    public void actionPerformed(ActionEvent event){
        Object obj = event.getSource();
        
        if(obj == moveTimer)
        {
            //movementPattern(p);
            //this.repaint();
        }
    }
    
    public Point getCoords(){
        return this.p.getLocation();
    }
    
    public Player getPlayer(){
        return this.p;
    }
    
    public void setPlayerLocation(Player p, Point location){
        this.p.setLocation(location);
    }
    
    
    /*
    public void movementPattern(Player p){
        if(p.x >=50 && p.x <=350 && p.y == 50){
            p.setLocation(p.x+1,p.y);
        } 
        if(p.x == 350 && p.y >= 50 && p.y <= 350)
        {
            p.setLocation(p.x, p.y+1);
        } 
        if(p.x <= 350 &&  p.x >= 50 && p.y == 350)
        {
            p.setLocation(p.x-1, p.y);
        } 
        if (p.x == 50 && p.y <= 350 && p.y >= 50)
        {
            p.setLocation(p.x, p.y-1);
        }
    }
    */
}
