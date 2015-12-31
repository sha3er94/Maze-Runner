/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static mazegame.Map.file;

/**
 *
 * @author Ramy
 */
public class Board extends JPanel implements ActionListener { 
    private Timer timer;
    private Map map;
    private Player player;
    private Player player2;
    private Monsters monster1;
    private Monsters monster2;
    private String Message="";
    private String Message2="";
    private String score="";
    private StringBuilder sb = new StringBuilder();
    private Font font = new Font("serif",Font.BOLD,48);
    private Font font1 = new Font("serif",Font.BOLD,24);
    private Boolean win = false;
    private Boolean lose = false;
    private Boolean gift = false;
    private Boolean menu =true;
    private boolean finish = false;
    private boolean stop = false;
    private boolean stop2 = false;
    private boolean stop3 = false;
    private int S1,S2;
    private double t1=0,t2=0;
    private String Score2 = "";   
    private boolean which1= false ;
    private boolean which2= false ;
    JButton Next,Next1;
    JButton NewGame,NewGame1;
    public static boolean  right1 = false ;
    public static boolean  right2 =false ;
    public static boolean  left1 = false ;
    public static boolean left2 = false ;
    public Board(){
                player = new Player();
                player2= new Player();
                monster1 = new Monsters();
                monster2 = new Monsters();
                map = new Map();
                addKeyListener(new Al());
                setFocusable(true);
                timer = new Timer(25,this);
                timer.start();
                t1=System.currentTimeMillis();
                JPanel btnPanel = new JPanel();
        //btnPanel.setBackground(Color.PINK);
         Box thebox = Box.createHorizontalBox();
        Next = new JButton("Go To Level 2");
        Next.setToolTipText("Go To Next Level");
        Next.addActionListener(this);
        NewGame = new JButton("New Game");
        NewGame.setToolTipText("New Game");
        NewGame.addActionListener(this);
        NewGame1 = new JButton("Start New Game");
        NewGame1.setToolTipText("Start New Game");
        NewGame1.addActionListener(this);
        thebox.add(Next);
        thebox.add(NewGame);
        thebox.add(NewGame1);
        btnPanel.add(thebox);
        this.add(btnPanel, BorderLayout.SOUTH);
        Next.setVisible(false);
        NewGame1.setVisible(false);
        Next1 = new JButton("Go To Level 3");
        Next1.setToolTipText("Go To Level 3");
        Next1.addActionListener(this);
        thebox.add(Next1);
        btnPanel.add(thebox);
        this.add(btnPanel, BorderLayout.SOUTH);
        Next1.setVisible(false);
        NewGame.setVisible(false);
            }
    public void paint(Graphics g)
    {super.paint(g);
    
    if(!win&&!lose){
    for(int y=0; y<20;y++){
        for(int x=0;x<20;x++){
            gift=false;
        if(map.GetMap(x,y).equals("g")){
            g.drawImage(map.Getgrass(), x*32, y*32, null);
        }if(map.GetMap(x,y).equals("w")){
            g.drawImage(map.Getwall(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("a")){
            g.drawImage(map.getBorder(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("t")){
            g.drawImage(map.getTree(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("f")){
            g.drawImage(map.Getfinish(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("b")){
            g.drawImage(map.GetBomb(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("o")){
            g.drawImage(map.getBomb2(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("j")){
            g.drawImage(map.GetGift(), x*32, y*32, null);
        }
        if(map.GetMap(x,y).equals("p")){
            g.drawImage(map.getWeapon(), x*32, y*32, null);
        }
        
    g.setColor(Color.white);
    g.setFont(font1);
    g.drawString("1: "+ score,10,30);
    g.drawString("2: "+ Score2 ,10,50);
    
        }
    }
    g.drawImage(player.GetPlayer(), player.getTilex()*32, player.getTiley()*32, null);
    g.drawImage(player2.GetPlayer1(), player2.getTilex()*32, player2.getTiley()*32, null);
    g.drawImage(monster1.GetMonster1(),monster1.getTilemx()*32 ,monster1.getTilemy()*32, null);
    g.drawImage(monster2.GetMonster2(),monster2.getTilemx()*32 ,monster2.getTilemy()*32, null);
    }
   if ( right1 ){ 
       int yy=100000;
       while (yy!=0){
    g.drawImage(player.GetPlayerR1(), player.getTilex()*32, player.getTiley()*32, null);
      yy--; }
    right1= false;}
    if (right2){
        int dd=1000000;
        while(dd!=0){
    g.drawImage(player.GetPlayerR2(), player.getTilex()*32, player.getTiley()*32, null);
      dd--;  }right2= false;
    }
    if (left1){
        int uu =100000;
        while(uu!=0){
    g.drawImage(player.GetPlayerL1(), player.getTilex()*32, player.getTiley()*32, null);
     uu--;  
        }left1= false;
    }
    if (left2){
        int nn =1000000;
        while(nn!=0){
    g.drawImage(player.GetPlayerL2(), player.getTilex()*32, player.getTiley()*32, null);
       nn--; }
        left2= false;
      }
    
    
    
    
    if(win || lose){
        
        if(win == true && !map.returnPath().equals("Map2.txt") && finish == false){
            Next.setVisible(true);
            System.out.println("MAP 2");
            finish = true;
        }
        if(win == true && map.returnPath().equals("Map2.txt")&& stop == false){
            Next.setVisible(false);
            Next1.setVisible(true); 
            System.out.println("Map 3");
            stop = true;
        }
        if (win == true && map.returnPath().equals("Map3.txt") && stop2 == false){
            Next.setVisible(false);
            Next1.setVisible(false);
            NewGame1.setVisible(true);
            stop2 = true;
           //System.out.println("TRUE FINISH");
      }
        
        if(lose == true && stop3 == false){
            NewGame.setVisible(true);
            stop3 = true;
        }
        
    g.setColor(Color.red);
    g.setFont(font);
    g.drawString(Message, 220, 200);
    g.drawString("Time= "+Message2.substring(0,4)+"s", 220, 250);
    g.drawString("1: "+ score,100,500);
    g.drawString("2: "+ Score2 ,100,600);
    }
    
    
    }
    public class Al extends KeyAdapter{
        private Boolean gift = false;
         private boolean which1= false ;
         private boolean which2= false ;
        public void keyPressed(KeyEvent  e){
            int Keycode = e.getKeyCode();
            if(Keycode == KeyEvent.VK_UP){
                if(!map.GetMap(player.getTilex(), player.getTiley()-1).equals("w")&&!map.GetMap(player.getTilex(), player.getTiley()-1).equals("a") &&!map.GetMap(player.getTilex(), player.getTiley()-1).equals("t") ){
                player.move( 0, -1);}
                
            }if(Keycode == KeyEvent.VK_LEFT){
                if(!map.GetMap(player.getTilex()-1, player.getTiley()).equals("w")&&!map.GetMap(player.getTilex()-1, player.getTiley()).equals("a")&&!map.GetMap(player.getTilex()-1, player.getTiley()).equals("t")){
               left1=true;
                    player.move( -1, 0);}
                
            }if(Keycode == KeyEvent.VK_DOWN){
                if(!map.GetMap(player.getTilex(), player.getTiley()+1).equals("w")&&!map.GetMap(player.getTilex(), player.getTiley()+1).equals("a")&& !map.GetMap(player.getTilex(), player.getTiley()+1).equals("t") ){
                player.move( 0, 1);}
                
            }if(Keycode == KeyEvent.VK_RIGHT){
                if(!map.GetMap(player.getTilex()+1, player.getTiley()).equals("w")&&!map.GetMap(player.getTilex()+1, player.getTiley()).equals("a")&& !map.GetMap(player.getTilex()+1, player.getTiley()).equals("t")){
                right1=true;
                    player.move( 1, 0);}
                
            }
            if(map.GetMap(player.getTilex(), player.getTiley()).equals("j")){
           S1+=10;
           score = Integer.toString(S1);
            System.out.println("1: " +S1);
           gift=true;
           
           map.SetBomb(player.getTilex(),player.getTiley());
                System.out.println("THE Gift"+gift);
        }
            
            if(map.GetMap(player.getTilex(), player.getTiley()).equals("p")){
           S1+=5;
           score = Integer.toString(S1);
            System.out.println("1: " +S1);
           gift=true;
           which1=true;
           map.SetBomb(player.getTilex(),player.getTiley());
                System.out.println("THE Gift"+gift);
        }
              if (Keycode == KeyEvent.VK_SPACE){
                  System.out.println(gift);
                  if (gift == true && which1 == true ){
                if(map.GetMap( player.getTilex()+1 ,player.getTiley()).equals("w"))
            {
            map.SetBomb(player.getTilex()+1,player.getTiley());
            } 
            else if( map.GetMap(player.getTilex()+1 ,player.getTiley()).equals("b"))
            {  
              map.SetBomb(player.getTilex()+1,player.getTiley());
            }
                if (player.getTilex()+1==monster1.getTilemx()&& player.getTiley()==  monster1.getTilemy()){
                  Message="player1"
                    + " Win";
            win = true;
            lose=false;
           // monster1.SetMonster1();
                 }  
            if (player.getTilex()+1==monster2.getTilemx()&& player.getTiley()==  monster2.getTilemy()){
              //Message="player1"
              //      + " Win";
            //win = true;
            //lose=false;
            monster2.SetMonster2();
                 }
            }
                  
            }
        
            if(Keycode == KeyEvent.VK_W){
                if(!map.GetMap(player2.getTilex(), player2.getTiley()-1).equals("w")&&!map.GetMap(player2.getTilex(), player2.getTiley()-1).equals("a")&& !map.GetMap(player2.getTilex(), player2.getTiley()-1).equals("t")){
                player2.move( 0, -1);}
                
            }if(Keycode == KeyEvent.VK_A){
                if(!map.GetMap(player2.getTilex()-1, player2.getTiley()).equals("w")&&!map.GetMap(player2.getTilex()-1, player2.getTiley()).equals("a")&& !map.GetMap(player2.getTilex()-1, player2.getTiley()).equals("t")){
               left2=true;
                    player2.move( -1, 0);}
                
            }if(Keycode == KeyEvent.VK_S){
                if(!map.GetMap(player2.getTilex(), player2.getTiley()+1).equals("w")&&!map.GetMap(player2.getTilex(), player2.getTiley()+1).equals("a")&& !map.GetMap(player2.getTilex(), player2.getTiley()+1).equals("t")){
                player2.move( 0, 1);}
                
            }if(Keycode == KeyEvent.VK_D){
                if(!map.GetMap(player2.getTilex()+1, player2.getTiley()).equals("w")&&!map.GetMap(player2.getTilex()+1, player2.getTiley()).equals("a")&& !map.GetMap(player2.getTilex()+1, player2.getTiley()).equals("t")){
                left2=true;
                    player2.move( 1, 0);}
                
            }
//             if(Keycode == KeyEvent.VK_Q)
//                 {
//                     if(map.GetMap(player2.getTilex()+1, player2.getTiley()).equals("w")){
//                         map.setWall(null);
//                     }
//                 }
            // the weapon with the key x 
            if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("j")){
           S2+=10;
          Score2 = Integer.toString(S2);
           System.out.println("2: " +S2);
           gift=true; 
           map.SetBomb(player2.getTilex(),player2.getTiley());
              System.out.println("the gift"+ gift);
        }  
          if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("p")){
           S2+=5;
          Score2 = Integer.toString(S2);
           System.out.println("2: " +S2);
           gift=true; 
           which2=true;
           map.SetBomb(player2.getTilex(),player2.getTiley());
              System.out.println("the gift"+ gift);
        }  
            
            if (Keycode == KeyEvent.VK_X){
            if (gift== true && which2 == true){
                if(map.GetMap( player2.getTilex()+1 ,player2.getTiley()).equals("w"))
            {
            map.SetBomb(player2.getTilex()+1,player2.getTiley());
            } 
            else if( map.GetMap(player2.getTilex()+1 ,player2.getTiley()).equals("b"))
            {  
              map.SetBomb(player2.getTilex()+1,player2.getTiley());
            } 
                if (player2.getTilex()+1==monster1.getTilemx()&& player2.getTiley()==  monster1.getTilemy()){
                  Message="player2"
                    + " Win";
            win = true;
            lose=false;
            //monster1.SetMonster1();
                 }  
            if (player2.getTilex()+1==monster2.getTilemx()&& player2.getTiley()==  monster2.getTilemy()){
         //     Message="player1"
           //         + " Win";
          //  win = true;
           // lose=false;
            monster2.SetMonster2();
                 }
            }
            }
//          if(map.GetMap(player.getTilex(), player.getTiley()).equals("j")){
//           S1+=10;
//           score = Integer.toString(S1);
//            System.out.println("1: " +S1);
//           gift=true;
//           map.SetBomb(player.getTilex(),player.getTiley());
//            
//        }
            Random t = new Random();
     for(int r = 1 ; r<=4 ; r++){
     int randomg = t.nextInt(4); 
       switch(randomg){
           case 1: { 
               if (!map.GetMap(monster1.getTilemx()+1, monster1.getTilemy()).equals("w")&&!map.GetMap(monster1.getTilemx()+1, monster1.getTilemy()).equals("a")&& !map.GetMap(monster1.getTilemx()+1, monster1.getTilemy()).equals("t"))
           { monster1.movem(1,0);} 
           break;
           }
           case 2:{
               if (!map.GetMap(monster1.getTilemx(), monster1.getTilemy()+1).equals("w")&&!map.GetMap(monster1.getTilemx(), monster1.getTilemy()+1).equals("a")&& !map.GetMap(monster1.getTilemx(), monster1.getTilemy()+1).equals("t")) 
           {  monster1.movem(0, 1);}
           break;
           }     
           case 3:{if (!map.GetMap(monster1.getTilemx()-1, monster1.getTilemy()).equals("w")&&!map.GetMap(monster1.getTilemx()-1, monster1.getTilemy()).equals("a")&& !map.GetMap(monster1.getTilemx()-1, monster1.getTilemy()).equals("t"))
           {  monster1.movem( -1, 0);}
           break;}
           case 4 :{ if (!map.GetMap(monster1.getTilemx(), monster1.getTilemy()-1).equals("w")&&!map.GetMap(monster1.getTilemx(), monster1.getTilemy()-1).equals("a")&& !map.GetMap(monster1.getTilemx(), monster1.getTilemy()-1).equals("t"))
           { monster1.movem( 0, -1);}
           break;
           } 
       
       } }
     Random rand = new Random ();
     for( int mn=1;mn<=4;mn++){
         int randmon = rand.nextInt(4);
      switch(randmon){
          case 1:{ if (!map.GetMap(monster2.getTilemx(), monster2.getTilemy()-1).equals("w")&&!map.GetMap(monster2.getTilemx(), monster2.getTilemy()-1).equals("a")&& !map.GetMap(monster2.getTilemx(), monster2.getTilemy()-1).equals("t")){
                monster2.movem( 0, -1);}
          break;}
          case 2 : { if (!map.GetMap(monster2.getTilemx()-1, monster2.getTilemy()).equals("w")&&!map.GetMap(monster2.getTilemx()-1, monster2.getTilemy()).equals("a")&& !map.GetMap(monster2.getTilemx()-1, monster2.getTilemy()).equals("t")){
                monster2.movem( -1, 0);}
          break;}
          case 3: { if (!map.GetMap(monster2.getTilemx(), monster2.getTilemy()+1).equals("w")&&!map.GetMap(monster2.getTilemx(), monster2.getTilemy()+1).equals("a")&& !map.GetMap(monster2.getTilemx(), monster2.getTilemy()+1).equals("t")){
        monster2.movem(0, 1);}
          break;}
          case 4 :{if (!map.GetMap(monster2.getTilemx()+1, monster2.getTilemy()).equals("w")&&!map.GetMap(monster2.getTilemx()+1, monster2.getTilemy()).equals("a")&& !map.GetMap(monster2.getTilemx()+1, monster2.getTilemy()).equals("t")){
         monster2.movem(1, 0);}
        break;}}}
     
        
        
        
            
      
        
        
        }
        
        
        
         public void keyReleased(KeyEvent  e){
              
        }
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
if (player.getTilex()==monster1.getTilemx()&& player.getTiley()==  monster1.getTilemy()){
       Message="Player1"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        if (player.getTilex()==monster2.getTilemx()&& player.getTiley()==  monster2.getTilemy()){
       Message="Player1"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }if (player2.getTilex()==monster1.getTilemx()&& player2.getTiley()==  monster1.getTilemy()){
       Message="Player2"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        if (player2.getTilex()==monster2.getTilemx()&& player2.getTiley()==  monster2.getTilemy()){
       Message="Player2"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        
            if (e.getSource() == Next) {
                if(win==true){
            try {
            // TODO add your handling code here:
             file="Map2.txt";
            Frame1 f1=new Frame1();
            f1.startGame();
            //Next.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        }
                else
                    Next.setVisible(false);
            }
            if (e.getSource() == Next1) {
                if(win==true){
            try {
            // TODO add your handling code here:
             file="Map3.txt";
             finish = true;
            Frame1 f1=new Frame1();
            f1.startGame();
            
            //Next1.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        }
                else
                    Next1.setVisible(false);
            }
            if (e.getSource()== NewGame){
                
    try {
        
        Frame1 f1 = new Frame1();
        f1.startGame();
        
    } catch (IOException ex) {
        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
            if (e.getSource()== NewGame1){
                
    try {
        file = "Map.txt";
        Frame1 f1 = new Frame1();
        f1.startGame();
        NewGame1.setVisible(true);
    } catch (IOException ex) {
        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
            if(map.GetMap(player.getTilex(), player.getTiley()).equals("f")){
            Message="player1"
                    + " Win";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            win = true;
            lose=false;
            
        }
        if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("f")){
            Message="player2"
                    +" Win";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            win = true;
            lose = false;
            
        }
        if(map.GetMap(player.getTilex(), player.getTiley()).equals("b")){
            Message="Player1"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        
        if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("b")){
            Message="player2"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        if(map.GetMap(player.getTilex(), player.getTiley()).equals("o")){
            Message="Player1"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        
        if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("o")){
            Message="player2"
                    +"lose";
            t2=System.currentTimeMillis();
            double k = (t2-t1)*0.001;
            sb.append(k);
            Message2=sb.toString();
            lose=true;
            win=false;
            
        }
        
//        if(map.GetMap(player.getTilex(), player.getTiley()).equals("a")){
//            Message="Player1"
//                    +"lose";
//            lose=true;
//            win=false;
//            
//        }
//        if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("a")){
//            Message="player2"
//                    +"lose";
//            lose=true;
//            win=false;
//            
//        }
      //  if(map.GetMap(player.getTilex(), player.getTiley()).equals("j")){
        //   S1+=10;
          // score = Integer.toString(S1);
            //System.out.println("score: " +S1);
          // gift=true;
           //map.SetBomb(player.getTilex(),player.getTiley());
        //}
       // if(map.GetMap(player2.getTilex(), player2.getTiley()).equals("j")){
         //  S2++;
         // Score2 = Integer.toString(S2);
          // System.out.println("Score" +S2);
          // gift=true; 
          // map.SetBomb(player2.getTilex(),player2.getTiley());
        //}
        repaint();
         //To change body of generated methods, choose Tools | Templates.
    }
//    public void delay(){
//        long ramy = System.currentTimeMillis();
//        System.out.println("ramy : "+ramy);
//        while (!lose && !win){
//            if ((System.currentTimeMillis()-ramy) >= 1000)
//            {
//               
//                ramy=ramy+1000;
//            }
//        }
//        }
    
}
