///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mazegame;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.event.ActionListener;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
///**
// *
// * @author Ramy
// */
//public class paint  extends JPanel {
//    private Timer timer;
//    private Map map;
//    private Player player;
//    private Player player2;
//    private String Message="";
//    private String score="";
//    private Font font = new Font("serif",Font.BOLD,48);
//    private Boolean win = false;
//    private Boolean lose = false;
//    private Boolean gift = false;
//    private int S1,S2;
//    
//    public paint(){
//                player = new Player();
//                player2= new Player();
//                map = new Map();
//                timer = new Timer(25, (ActionListener) this);
//                timer.start();
//            }
//    
//    public void paint(Graphics g)
//    {super.paint(g);
//    if(!win&&!lose){
//    for(int y=0; y<20;y++){
//        for(int x=0;x<20;x++){
//        if(map.GetMap(x,y).equals("g")){
//            g.drawImage(map.Getgrass(), x*32, y*32, null);
//        }if(map.GetMap(x,y).equals("w")){
//            g.drawImage(map.Getwall(), x*32, y*32, null);
//        }
//        if(map.GetMap(x,y).equals("f")){
//            g.drawImage(map.Getfinish(), x*32, y*32, null);
//        }
//        if(map.GetMap(x,y).equals("b")){
//            g.drawImage(map.GetBomb(), x*32, y*32, null);
//        }
//        if(map.GetMap(x,y).equals("j")){
//            g.drawImage(map.GetGift(), x*32, y*32, null);
//        }
//        if(map.GetMap(x,y).equals("a")){
//            g.drawImage(map.GetWater(), x*32, y*32, null);
//        }
//        }
//    }
//    g.drawImage(player.GetPlayer(), player.getTilex()*32, player.getTiley()*32, null);
//    g.drawImage(player2.GetPlayer1(), player2.getTilex()*32, player2.getTiley()*32, null);
//    if(gift){
//    g.setColor(Color.red);
//    g.setFont(font);
//    g.drawString(score, 650, 100);
//    
//    }
//    }
//    if(win || lose){
//    g.setColor(Color.red);
//    g.setFont(font);
//    g.drawString(Message, 300, 300);
//    }
//    
//    
//    }
//    
//}
