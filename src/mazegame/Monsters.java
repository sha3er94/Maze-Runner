/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Myriam
 */
public class Monsters { 
    private int Tilemx,Tilemy;
    private Image m1,m2 ;
    public Monsters(){
        ImageIcon img = new ImageIcon("dying1.png");
        m1=img.getImage();
        img = new ImageIcon("monster-moving1.png");
        m2=img.getImage();
    
    Tilemx=17;
    Tilemy=2;
    }
     public Image GetMonster1(){
        return m1;
    }
    public Image GetMonster2(){
        return m2;
    }
    public void SetMonster1(){
        this.m1=null;
    }
      public void SetMonster2(){
        this.m1=null;
    }
    public void movem(int dx , int dy ){
       
        Tilemx+=dx;
        Tilemy+=dy;
        
        
    }
   

    /**
     * @return the x
     */
  

    /**
     * @return the tilex
     */
    public int getTilemx() {
        return Tilemx;
    }

    /**
     * @return the tiley
     */
    public int getTilemy() {
        return Tilemy;
    }

    void wait(Timer timer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

