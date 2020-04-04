/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * @author Admin
 */
public class CurrentStatus extends JPanel{
    JTextArea txt_area;
    JScrollPane scroll_pane;
    Cursor cur_hand;
    CurrentStatus(){
        txt_area= new  JTextArea();
        scroll_pane=new JScrollPane(txt_area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
 
        
        
       
     this.design();
     this.handleEvent();
        
    }
    
    
     private void handleEvent(){
        
    }
    
    private void design(){
        this.setLayout(null);
        this.setPos(this.scroll_pane,5,5,540,345);
        
        
    }
        
         private void setPos(Component component,int x,int w,int width,int height){
        this.add(component);
        //component.setPreferredSize(new Dimension(width,height));
        component.setBounds(x, w, width, height);
    
    

} 
    }
    

