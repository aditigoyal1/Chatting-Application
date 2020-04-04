package serverapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Client extends JFrame {
    Client(){
        JLabel lbClient=new JLabel("Select CLient:");
        JButton btnviewLog=new JButton("View Log");
        btnviewLog.setBounds(260,10,100,30);
        this.add(btnviewLog);
        Cursor hand=new Cursor(Cursor.HAND_CURSOR);
        btnviewLog.setCursor(hand);
        
        
        lbClient.setBounds(10,10,100,30);
        this.add(lbClient);
        
        JComboBox cb1=new JComboBox();
        cb1.setBounds(120,10,100,30);
        this.add(cb1);
        
        
    
}
   public static void main(String[] args) {
        // TODO code application logic here
        Client s1=new Client();
        s1.setSize(400,400);
        s1.setLayout(null);
        s1.setVisible(true);
        
        s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
   
