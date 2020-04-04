/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientapp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import manager.ChatData;
import manager.ClientDetails;
import manager.CommonRes;
import manager.RequestCode;
import manager.ResponseCode;

/**
 *
 * @author pc
 */
class ClientSideThread extends Thread{

    ClientServices services;
    public ClientSideThread(ClientServices services) {
        this.services=services;
        this.start();
    }
    public void run(){
        try{
                  ObjectOutputStream out=new ObjectOutputStream(CommonRes.client.getOutputStream());
                  out.writeObject(RequestCode.LOGIN_ACK);
                }catch(Exception ex){
                    CommonRes.trackException("Error while sending acknowledgement :" + ex, services);
                }
                while(true){
                    try{
                        ObjectInputStream in=new ObjectInputStream(manager.CommonRes.client.getInputStream());
                        ResponseCode response=(ResponseCode) in.readObject();
                        if(response==ResponseCode.LOGIN){
                            Integer size=(Integer)in.readObject();
                            CommonRes.loggedInClients=new ArrayList<ClientDetails>();
                            for(int i=0;i<size;i++){
                                ClientDetails details=new ClientDetails();
                                details.clientId=(Integer)in.readObject();
                                details.name=in.readObject().toString();
                                CommonRes.loggedInClients.add(details);
                                services.addClient(details);
                            }
                        }
                        
                        if(response==ResponseCode.NEW_LOG){
                            ClientDetails details=new ClientDetails();
                            details.clientId=(Integer)in.readObject();
                            details.name=in.readObject().toString();
                            CommonRes.loggedInClients.add(details);
                            services.addClient(details);
                        }
                        if(response==ResponseCode.CHAT_SEND){
                            Integer senderId=(Integer)in.readObject();
                            String time=in.readObject().toString();
                            String msg=in.readObject().toString();
                            
                            for(ClientDetails details:CommonRes.loggedInClients){
                                if(details.clientId==senderId){
                                    ChatData chatdata=new ChatData();
                                    chatdata.from=details.name;
                                    chatdata.time=time;
                                    chatdata.msg=msg;
                                    details.chatdata.add(chatdata);
                                    if(CommonRes.activeClient!=-1 && CommonRes.loggedInClients.get(CommonRes.activeClient).clientId==senderId)
                                        this.services.addChatRow(chatdata);
                                    break;
                                }
                            }
                        }
                        /*if(response==ResponseCode.LOGIN){
                            
                        }
                        
                        if(response==ResponseCode.LOGIN){
                            
                        }*/
                        
                        
                    }catch(Exception ex){
                        manager.CommonRes.trackException("Error on client side thread :" + ex, services);
                    }
                }
    }
    
}
