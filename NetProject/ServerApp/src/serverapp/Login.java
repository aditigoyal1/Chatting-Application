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

public class Login extends JPanel implements ActionListener{
    JButton btn_login;
    JLabel lbl_loginid,lbl_mesg;
    Font f;
    Color c2; 
    JLabel lbl_password; 
    JTextField txt_loginid; 
    JPasswordField txt_password;        
    public Login(){
        this.setLayout(null);
        this.lbl_mesg=new JLabel("");
        lbl_loginid=new JLabel("Login Id:");
        f=new Font("Arial",Font.BOLD,20);
   
        lbl_loginid.setFont(f);
        lbl_loginid.setBackground(Color.red);
    
        c2=new Color(102,83,104);
        
     
        lbl_password=new JLabel("Password:");
        lbl_password.setFont(f);
        txt_loginid=new JTextField();
        txt_password=new JPasswordField();
        
        btn_login=new JButton(new ImageIcon("‪‪‪Desert.jpg"));

        lbl_password.setBounds(50, 100, 100, 30);
        lbl_loginid.setBounds(50, 50, 100,30);
        txt_loginid.setBounds(150, 50, 100, 30);
        txt_password.setBounds(150, 100, 100, 30);
        btn_login.setBounds(150, 200, 100, 30);
        
       
         this.design();
         this.handleEvent();
    }   
    private void handleEvent(){
       this.btn_login.addActionListener(this);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        String pass=new String(this.txt_password.getPassword()).trim();
        if(this.txt_loginid.getText().trim().equals("") || pass.trim().equals("")){
            this.lbl_mesg.setText("Login ID or Password not provided!!!");
            return;
        }
        if(this.txt_loginid.getText().trim().equals("admin") && pass.equals("admin")){
            manager.CommonRes.win.tbp_server.setEnabledAt(2, true);
            manager.CommonRes.win.tbp_server.setEnabledAt(3, true);
            manager.CommonRes.win.tbp_server.setEnabledAt(4, true);
            manager.CommonRes.win.tbp_server.setEnabledAt(5, true);
            manager.CommonRes.win.tbp_server.setEnabledAt(1,false);
        }else{
            JOptionPane.showMessageDialog(manager.CommonRes.win,"Login/Password Invalid!!!","Login",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
  
    private void design(){
        this.setPos(this. lbl_password,50, 100, 100, 30);
        this.setPos(this.   lbl_loginid,50, 50, 100,30);
        this.setPos(this. txt_loginid,150, 50, 100, 30);
        this.setPos(this.  txt_password,150, 100, 100, 30);
        this.setPos(this.btn_login,150, 200, 100, 30);
        //this.setPos(this.lbl_mesg,);
        
    }
    
    private void setPos(Component component,int x,int y,int width,int height){
        this.add(component);
        component.setBounds(x, y, width, height);
    }

    

    
    
}