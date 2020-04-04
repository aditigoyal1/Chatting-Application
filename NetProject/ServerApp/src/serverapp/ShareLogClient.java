/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ShareLogClient extends JPanel {
    JLabel lbl_client;
    JButton btn_viewlog;
    JComboBox cb_view;
    Cursor cur_hand;
    
    
    
   public ShareLogClient(){
       this.setLayout(null);
        lbl_client=new JLabel("Select CLient:");
        btn_viewlog=new JButton("View Log");
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
        btn_viewlog.setCursor(cur_hand);
        cb_view=new JComboBox();
      
        
        this.design();
        this.handleEvent();
        
    }
     private void handleEvent(){
        
    }
    
         private void design(){
        this.setPos(this.lbl_client,10,10,100,30);
        this.setPos(this.cb_view,110,10,100,30);
        this.setPos(this.btn_viewlog,240,10,100,30);
        
    }
        
         private void setPos(Component component,int x,int y,int width,int height){
        this.add(component);
        component.setBounds(x, y, width, height);
    
    

}}
   

