/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverapp;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import manager.ClientDetails;
import static manager.CommonRes.*;
/**
 *
 * @author pc
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            win=new ServerWin();
            final int WIDTH=600;
            final int HEIGHT=500;
            Toolkit tool=Toolkit.getDefaultToolkit();
            Dimension size= tool.getScreenSize();
            win.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
            win.setVisible(true);
            win.setResizable(false);
            win.setTitle("Server Window");
            
            ServerSocket server=new ServerSocket(2244);
            loggedInClients=new ArrayList<ClientDetails>();
            running=true;
            while(running){
                Socket client=server.accept();
                new ClientHandler(client);
            }
        }catch(Exception ex){
            trackException("Problem in ServerApp : " + ex);
        }
    }
    
}
