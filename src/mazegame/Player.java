/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ramy
 */
public class Player {
    private int tilex,tiley;
    private Image p,p2,p11,p12,p21,p22 ;
    public Player(){
        ImageIcon img = new ImageIcon("red_ball.png");
        p=img.getImage();
        img = new ImageIcon("blue_ball.png");
        p2=img.getImage();
         img = new ImageIcon("right.gif");
        p11=img.getImage();
         img = new ImageIcon("left.gif");
        p12=img.getImage();
         img = new ImageIcon("right(1).png");
        p21=img.getImage();
         img = new ImageIcon("left(1).png");
        p22=img.getImage();
        
    
    tilex=1;
    tiley=1;
    }
    public Image GetPlayer(){
        return p;
    }
    public Image GetPlayer1(){
        return p2;
    }
     public Image GetPlayerR1(){
        return p11;
    }
      public Image GetPlayerL1(){
        return p12;
    }
     public Image GetPlayerR2(){
        return p21;
    }
      public Image GetPlayerL2(){
        return p22;
    }
    
    
    public void move(int dx , int dy ){
       
        tilex+=dx;
        tiley+=dy;
        
        
    }
   

    /**
     * @return the x
     */
  

    /**
     * @return the tilex
     */
    public int getTilex() {
        return tilex;
    }

    /**
     * @return the tiley
     */
    public int getTiley() {
        return tiley;
    }
    
}
