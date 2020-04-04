/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
/**
 *
 * @author Dinesh
 */
public class Ipentry extends JFrame implements ActionListener{
    JLabel lbl_IP,lbl_mesg;
    JTextField txtf_IP;
    JButton btn_IPok;
    public Ipentry()
    {
        this.setLayout(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.lbl_IP=new JLabel("Enter Server's IP Address");
        this.txtf_IP=new JTextField(20);
        this.btn_IPok=new JButton("Connect");
        this.lbl_mesg=new JLabel("");
        this.lbl_mesg.setForeground(Color.red);

        this.design();
        this.handleEvent();
    }   
    
    private void handleEvent(){
        this.btn_IPok.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.txtf_IP.getText().trim().equals("")){
            this.lbl_mesg.setText("IP Address not provided!!!");
            return;
        }
        try{
           InetAddress inet=InetAddress.getByName(this.txtf_IP.getText().trim());
           manager.CommonRes.client=new Socket(inet,2244);
           JOptionPane.showMessageDialog(this, "Successfully Connected to server...","IP Entry",JOptionPane.INFORMATION_MESSAGE);
           
            Login login=new Login();
            final int WIDTH=300;
            final int HEIGHT=200;
            Toolkit tool=Toolkit.getDefaultToolkit();
            Dimension size= tool.getScreenSize();
            login.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
            login.setVisible(true);
            login.setResizable(false);
            login.setTitle("LOGIN");
            this.dispose();
        }catch(Exception ex){
            manager.CommonRes.trackException("Error while connecting to server :" + ex, this);
        }
    }
    
    
    private void design(){
        this.setPos(this.lbl_IP,30,20,200,20);
        this.setPos(this.txtf_IP,30,60,200,20);
        this.setPos(this.btn_IPok,30,100,100,20);
        this.setPos(this.lbl_mesg,30,140,150,20);
    }
    
    private void setPos(Component component,int x,int y,int width,int height){
        this.add(component);
        component.setBounds(x, y, width, height);
    }

    
    
}
