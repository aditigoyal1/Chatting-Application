/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class ClientDetails {
    public int clientId;
    public String name;
    public ArrayList<ChatData> chatdata;
    public ClientDetails(){
        this.chatdata=new ArrayList<ChatData>();
    }
}
