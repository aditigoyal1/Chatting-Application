/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 *
 * @author Admin
 */
public class Chatscreen extends JFrame {
     JTextArea txt_area;
    JScrollPane scrollpane_online,scrollpane_chat,scrollpane_msg;
     JButton btn_send;
      JButton btn_logout;
      Cursor cur_hand;
      JTable table_online,table_chat;
      JTabbedPane tbp_chatscreen;
      
      JPanel pnl_2;
      Panel1 pnl_1;
      
     // Object head[];

   Chatscreen(){
        txt_area= new  JTextArea();
        scrollpane_msg=new JScrollPane(txt_area);
        btn_send=new JButton("Send");
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
        btn_send.setCursor(cur_hand);
   
        btn_logout=new JButton("Logout");
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
        btn_logout.setCursor(cur_hand);
        
        
        
       Object head[]=new Object[]{"Online"};
       Object data[][]=new Object[30][1];
       table_online =new JTable(data,head);
       scrollpane_online=new JScrollPane(table_online);
       
       Object head1[]=new Object[]{"Time","By","Message"};
       Object data1[][]=new Object[20][3];
       table_chat =new JTable(data1,head1);
        scrollpane_chat=new JScrollPane(table_chat);
       
       pnl_1=new Panel1();
       pnl_2=new JPanel();
       tbp_chatscreen=new JTabbedPane();
       
        tbp_chatscreen.add("Panel1",this.pnl_1);
        tbp_chatscreen.add("panel2",this.pnl_2);
   
        
        
         this.design();
     this.handleEvent();
        
    }
    
    
     private void handleEvent(){
        
    }
    
    private void design(){
        this.setLayout(null);
       
         this.setPos(this.scrollpane_online,10,0,100,400);
         this.setPos(this.btn_logout,0,410,100,30);
         // this.setPos(this.btn_send,450,410,100,30);
         //  this.setPos(this.scrollpane_chat,110,0,470,300);
           this.setPos(this.tbp_chatscreen,110,0,480,450);
        
        
    }
        
         private void setPos(Component component,int x,int w,int width,int height){
        this.add(component);
        //component.setPreferredSize(new Dimension(width,height));
        component.setBounds(x, w, width, height);
    
    

} 
   
    public static void main(String[] args) {
        // TODO code application logic here
        Chatscreen server_win=new Chatscreen();
        server_win.setSize(600,500);
        server_win.setLayout(null);
        server_win.setVisible(true);
        server_win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
