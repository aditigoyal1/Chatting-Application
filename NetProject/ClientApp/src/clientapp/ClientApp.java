/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientapp;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author pc
 */
public class ClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ipentry ipEntry=new Ipentry();
        final int WIDTH=300;
        final int HEIGHT=200;
        Toolkit tool=Toolkit.getDefaultToolkit();
        Dimension size= tool.getScreenSize();
        ipEntry.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);
        ipEntry.setVisible(true);
        ipEntry.setResizable(false);
        ipEntry.setTitle("IP Entry");
    }
    
}
