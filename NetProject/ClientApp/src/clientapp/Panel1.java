/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Admin
 */
public class Panel1 extends JPanel {
    
    JTextArea txt_area;
    JScrollPane scrollpane_chat,scrollpane_msg;
     JButton btn_send;
      Cursor cur_hand;
      JTable table_chat;
     
 
      
    
    public Panel1(){
          txt_area= new  JTextArea();
        scrollpane_msg=new JScrollPane(txt_area);
        btn_send=new JButton("Send");
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
        btn_send.setCursor(cur_hand);
   
        
        
        
       
       Object head1[]=new Object[]{"Time","By","Message"};
       Object data1[][]=new Object[20][3];
       table_chat =new JTable(data1,head1);
        scrollpane_chat=new JScrollPane(table_chat);
      
        
    
    
            this.design();
     this.handleEvent();
        
    }
    
    
     private void handleEvent(){
        
    }
    
    private void design(){
        this.setLayout(null);
       
         
          this.setPos(this.btn_send,450,410,100,30);
           this.setPos(this.scrollpane_chat,10,0,470,300);
           this.setPos(this.scrollpane_msg,10,310,470,90);
        
        
    }
        
         private void setPos(Component component,int x,int w,int width,int height){
        this.add(component);
        //component.setPreferredSize(new Dimension(width,height));
        component.setBounds(x, w, width, height);
    
    

} }
    

