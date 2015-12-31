/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import sun.audio.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Frame1 extends JFrame {
    
    public Frame1() throws FileNotFoundException, IOException
    {
//        ImageIcon icon;
//        icon = new ImageIcon("Menu.jpg");
//        JOptionPane.showMessageDialog(null, "     \t\t\t          Start New Game", "MazeGame", JOptionPane.INFORMATION_MESSAGE, icon);
//      
        
        

       this.setSize(660,670);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
               
       
              
       
    }
    public void startGame (){
        this.setTitle("Maze");
       this.add(new Board());
       this.setVisible(true);
    }
    public void Music () throws FileNotFoundException, IOException{
    String sonido = "Crazy Frog - Axel F (Mohamed El-Shaer Remix)-1.wav";
    InputStream in = new FileInputStream(sonido);
    AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
}
//     public void close(){
//
//WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOS­ING);
//Toolkit.getDefaultToolkit().getSystemEve­ntQueue().postEvent(winClosingEvent);
//
//}   
       
        }

   
    
 
