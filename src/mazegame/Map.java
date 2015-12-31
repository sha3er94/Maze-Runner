/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Ramy
 */
public class Map {
   public  static String file= "Map.txt" ;
    private Scanner m;
    private String Map[] = new String[20];
    private Image grass ,border, wall,finish,bomb,bomb2,gift,tree,weapon;
   
    public Map()
    { ImageIcon img= new ImageIcon("grass.jpg");
    grass = img.getImage();
    img = new ImageIcon("wall.png");
    wall = img.getImage();
    img = new ImageIcon("walls.jpg");
    border = img.getImage();
    img= new ImageIcon("tree.png");
    tree = img.getImage();
    img = new ImageIcon("images.jpg");
    finish = img.getImage();
    img = new ImageIcon("bomb.png");
    bomb = img.getImage();
    img = new ImageIcon("bomb2.jpg");
    bomb2 = img.getImage();
    img = new ImageIcon("gift.png");
    gift = img.getImage();
    img = new ImageIcon("weapon.png");
    weapon = img.getImage();
 
   
   

    openFile(file);
    readFile();
    closeFile();
    }
    public String returnPath(){
        return file;
    }
    public Image Getgrass()
    {return grass;
    }
    
    
   // public static void Setfile (String file ){
    // this.file =file;
    
    //}
     public Image Getwall()
    {return wall;
    }
     public Image Getfinish(){
         return finish;
     }
    public String GetMap(int x , int y )
    { String index = Map[y].substring(x,x+1); 
    return index;
    }
    public void openFile( String file )
    {   try {
        m = new Scanner(new File(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void readFile()
    {while(m.hasNext())
        for(int i=0;i<20;i++){
            Map[i]=m.next();
        }
    
    }
    public void closeFile()
    {}

    /**
     * @return the bomb
     */
    public Image GetBomb() {
        return bomb;
    }
    
    public void  SetBomb(int x , int y ) {
    char [] a = new char [14];  
            a= Map[y].toCharArray();
   // System.out.println(Map[y]);
    for (int i = 0 ; i < 20 ; i++ ){
    if ( x==i ){ a[i]='g';
        //System.out.println("the "+x;
     }}
       Map[y]=String.valueOf(a);
      //System.out.println( Map[y]);
    
    }
     //public void SetMap(int x , int y ){
     // int f =  Map[y].indexOf("b");
     // if (f==x)(
     //         Map[y]=Map[y].replaceFirst("b", "g")
    //          )
  //   }
   

    /**
     * @return the gift
     */
    public Image GetGift() {
        return gift;
    }

    /**
     * @return the tree
     */
    public Image GetWater() {
        return getTree();
    }

    /**
     * @param gift the gift to set
     */
    public void setGift(Image Gift) {
        this.gift=Gift;
       //char [] a = new char [14];  
       //     a= Map[y].toCharArray();
    //System.out.println(Map[y]);
    //for (int i = 0 ; i < 14 ; i++ ){
    //if ( x==i ){ a[i]='g';
        //System.out.println("the "+x;
     //}}
      // Map[y]=String.valueOf(a);
    }

    /**
     * @return the tree
     */
    public Image getTree() {
        return tree;
    }

    /**
     * @return the weapon
     */
    public Image getWeapon() {
        return weapon;
    }

    /**
     * @return the bomb2
     */
    public Image getBomb2() {
        return bomb2;
    }

    /**
     * @return the border
     */
    public Image getBorder() {
        return border;
    }
    
}
