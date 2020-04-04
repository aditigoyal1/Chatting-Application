/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;


/**
 *
 * @author Dinesh
 */
public class OtpEntry extends JFrame implements ActionListener {
    JLabel lbl_otp,lbl_mesg;
    JTextField txtf_otp;
    JButton btn_otpvari;
    public OtpEntry()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.lbl_mesg=new JLabel("");
        this.lbl_otp=new JLabel("Enter OTP");
        this.txtf_otp=new JTextField(20);
        this.btn_otpvari=new JButton("Varify");
        this.design();
        this.handleEvent();

    }  
	 private void handleEvent(){
        this.btn_otpvari.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.txtf_otp.getText().trim().equals("")){
            this.lbl_mesg.setText("OTP not provided!!!");
            return;
        }
        try{
           ObjectOutputStream out=new ObjectOutputStream(manager.CommonRes.client.getOutputStream());
           out.writeObject(manager.RequestCode.VALIDATE_OTP);
           out.writeObject(this.txtf_otp.getText().trim());
           JOptionPane.showMessageDialog(this, "Successfully OTP Varified","OTP Varification",JOptionPane.INFORMATION_MESSAGE);
           ObjectInputStream in=new ObjectInputStream(manager.CommonRes.client.getInputStream());
            String response=in.readObject().toString();
            if(response.equals("Failed")){
                JOptionPane.showMessageDialog(this, " OTP Invalid!!!","OTP",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(response.equals("Success")){
                JOptionPane.showMessageDialog(this, "OTP Successfully Verified","OTP",JOptionPane.INFORMATION_MESSAGE);
                //open chat window
            }
            
        }catch(Exception ex){
            manager.CommonRes.trackException("Error while varifing OTP :" + ex, this);
        }
    }
   	private void design(){
        this.setPos(this.lbl_otp,30,20,200,20);
        this.setPos(this.txtf_otp,30,60,200,20);
        this.setPos(this.btn_otpvari,100,100,100,20);
    }
    
    private void setPos(Component component,int x,int y,int width,int height){
        this.add(component);
        component.setBounds(x, y, width, height);
    }
}
