/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import manager.*;

/**
 *
 * @author Dinesh
 */
public class Login extends JFrame implements ActionListener{
    JLabel lbl_Headtxt,lbl_login,lbl_pass,lbl_mesg;
    JTextField txtf_login;
    JPasswordField txtf_pass;
    JButton btn_login;
    

    public Login() throws Exception {
        this.setLayout(null);
        this.lbl_Headtxt=new JLabel("Enter Your Login Details");
        this.lbl_login=new JLabel("Login ID :-");
        this.txtf_login=new JTextField(20);
        this.lbl_pass=new JLabel("Password :-");    
        this.txtf_pass=new JPasswordField(20);       
        this.btn_login=new JButton("LOGIN");
        this.lbl_mesg=new JLabel("");
        this.lbl_Headtxt.setSize(100,100);
		this.design();
		this.handleEvent();
        
        
    }
	private void handleEvent(){
        this.btn_login.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass=new String(this.txtf_pass.getPassword());
        if(this.txtf_login.getText().trim().equals("") || pass.trim().equals("")){
            this.lbl_mesg.setText("Login ID or Password not provided!!!");
            return;
        }
        try{
           
            ObjectOutputStream out=new ObjectOutputStream(manager.CommonRes.client.getOutputStream());
            out.writeObject(manager.RequestCode.LOGIN);
            out.writeObject(this.txtf_login.getText().trim());
            out.writeObject(pass.trim());
            ObjectInputStream in=new ObjectInputStream(manager.CommonRes.client.getInputStream());
            String response=in.readObject().toString();
            if(response.equals("Failed")){
                JOptionPane.showMessageDialog(this, "Login Id/Password Invalid!!!","Login",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(response.equals("Success")){
                JOptionPane.showMessageDialog(this, "Successfully Logged In","Login",JOptionPane.INFORMATION_MESSAGE);
                //open chat window
                
                 try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientServices services=new ClientServices();       
                services.setTitle("Welcome :" + Login.this.txtf_login.getText().trim());
                //new ClientServices().setVisible(true);
                services.setVisible(true);
                new ClientSideThread(services);
            }
        });
                this.dispose();
            
            }
            
            if(response.equals("Not verified")){
                OtpEntry otpEntry=new OtpEntry();
                final int WIDTH=300;
                final int HEIGHT=200;
                Toolkit tool=Toolkit.getDefaultToolkit();
                Dimension size= tool.getScreenSize();
                otpEntry.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
                otpEntry.setVisible(true);
                otpEntry.setResizable(false);
                otpEntry.setTitle("OTP Entry");
                this.dispose();
            }
            
            
        }catch(Exception ex){
            manager.CommonRes.trackException("Error while Login :" + ex, this);
        }
    }
	private void design(){
		this.setPos(this.lbl_Headtxt,20,20,200,20);
        this.setPos(this.lbl_login,20,60,200,20);
        this.setPos(this.txtf_login,120,60,200,20);
        this.setPos(this.lbl_pass,20,100,200,20);
        this.setPos(this.txtf_pass,120,100,200,20);
        this.setPos(this.btn_login,140,140,100,20);
    }
    
    private void setPos(Component component,int x,int y,int width,int height){
        this.add(component);
        component.setBounds(x, y, width, height);
    }


    
}
