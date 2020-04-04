/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Admin
 */
public class ServerWin extends JFrame{
    CurrentStatus currentStatus;
    LogStatus logStatus;
    ShareLogMch shareLogMch;
    ShareLogClient shareLogClient;
    Login login;
    Registration registration;
  //Panel5 pnl_5;
    Cursor  cur_hand;
    JButton btn_logout;
    JTabbedPane tbp_server;
    
    
    public ServerWin(){
        this.setLayout(null);   
        this.currentStatus=new CurrentStatus();
        this.logStatus=new LogStatus();
        this.shareLogMch=new ShareLogMch();
        this.shareLogClient=new ShareLogClient();
        this.login=new Login();
        this.registration=new Registration();
      //pnl_5=new JPanel();
        btn_logout=new JButton("Logout");
        cur_hand=new Cursor(Cursor.HAND_CURSOR);
        btn_logout.setCursor(cur_hand);
      
      
        
        tbp_server=new JTabbedPane();
       
        tbp_server.add("Current",this.currentStatus);
        tbp_server.add("Login",this.login);
        tbp_server.add("Registration",this.registration);
        tbp_server.add("Log Status",this.logStatus);
        tbp_server.add("Share Machine Log",this.shareLogMch);
        tbp_server.add("Share Client Log",this.shareLogClient);
      //tbp_server.add("Current",pnl_5);
        this.tbp_server.setEnabledAt(2,false);
        this.tbp_server.setEnabledAt(3,false);
        this.tbp_server.setEnabledAt(4,false);
        this.tbp_server.setEnabledAt(5,false);
        
         this.design();
         this.handleEvent();
    
    
    }    
    private void handleEvent(){
        
    }
    
        private void design(){
        this.setPos(this.btn_logout,450,20,100,20);
        this.setPos(this.tbp_server,20,50,550,400);
        
        
    }
    
    
    
    
         private void setPos(Component component,int x,int y,int width,int height)
         {
         this.add(component);
         component.setBounds(x, y, width, height);
         }
    
   
    
    
        
    /*public static void main(String[] args) {
        // TODO code application logic here
        ServerWin server_win=new ServerWin();
        server_win.setSize(400,400);
        server_win.setLayout(null);
        server_win.setVisible(true);
        server_win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
    
}
