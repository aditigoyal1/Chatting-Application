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

public class Registration extends JPanel implements ActionListener{
    Cursor hand;
    Font f1;
    JButton btn_Login;
    JLabel lbl_LoginID,lbl_mesg;
    JLabel lbl_Password;
    JLabel lbl_Cnfrmpassword;
    JLabel lbl_Name;        
    JLabel lbl_Email;  
    JTextField txt_LoginID;  
    JPasswordField txt_Password;   
    JPasswordField txt_cnfrmpassword;
    JTextField txt_Name;
    JTextField txt_Email;
    Registration(){
        this.setLayout(null);
         hand=new Cursor(Cursor.HAND_CURSOR);
         f1=new Font("Arial",Font.PLAIN,20);
         btn_Login=new JButton("Login");
         this.lbl_mesg=new JLabel("");
         btn_Login.setCursor(hand);
        // btn_Login.setEnabled(false);
        
         lbl_LoginID=new JLabel("LoginID:");
         lbl_Password=new JLabel("Password:");
         lbl_Cnfrmpassword=new JLabel("ConfirmPassword:");
      
         lbl_Name=new JLabel("Name:");
         lbl_Email=new JLabel("Email:");
        
         lbl_LoginID.setFont(f1);
         lbl_Password.setFont(f1);
         lbl_Cnfrmpassword.setFont(f1);
         lbl_Name.setFont(f1);
         lbl_Email.setFont(f1);
        
         txt_LoginID=new JTextField();
         txt_Password=new JPasswordField();
         txt_cnfrmpassword=new JPasswordField();
      
         txt_Name=new JTextField();
         txt_Email=new JTextField();
       
        // txt_Name.setBounds(210, 170, 100, 20);
         //txt_Email.setBounds(210, 220, 100, 20);
       
         this.design();
         this.handleEvent();
    }   
    private void handleEvent(){
       this.btn_Login.addActionListener(this);
    }
   public void actionPerformed(ActionEvent ae){
       String pass=new String(this.txt_Password.getPassword()).trim();
       if(this.txt_LoginID.getText().trim().equals("") || pass.trim().equals("")){
            this.lbl_mesg.setText("Login ID or Password not provided!!!");
            return;
        }
       String  sql="insert into clientmaster set " +
                    "LOGINID='" + this.txt_LoginID.getText().trim() + "'," +
                    "PASSWORD='" + pass + "'," +
                    "CLIENTNAME='" + this.txt_Name.getText().trim() + "'," +
                    "OTP=111," +
                    "STATUS=0," +
                    "EMAIL='" + this.txt_Email.getText().trim() + "'";
       int n=manager.ConnectionFactory.setData(sql);
       if(n>0){
           //show successfully registered
           //reset registration form
       }
               
               
       
   }
    
  
    private void design(){
        
        this.setPos(this. btn_Login,210,280,100,30);
        this.setPos(this. lbl_LoginID,50, 20, 100, 20);
        this.setPos(this.lbl_Password,50, 70, 100, 20);
        this.setPos(this.lbl_Name,50, 170, 100, 20);
        this.setPos(this.lbl_Cnfrmpassword,50, 120, 200, 20);
        this.setPos(this.lbl_Email,50, 220, 100, 20);
        this.setPos(this.txt_LoginID,210, 20, 100, 20);
        this.setPos(this.txt_Password,210, 70, 100, 20);
        this.setPos(this.txt_cnfrmpassword,210, 120, 100, 20);
        this.setPos(this.txt_Name,210, 170, 100, 20);
        this.setPos(this.txt_Email,210, 220, 100, 20);
    }
    
    private void setPos(Component component,int x,int y,int width,int height){
        
        this.add(component);
        component.setBounds(x, y, width, height);
    }

    
    
}