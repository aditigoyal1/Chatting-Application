/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverapp;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.Calendar;
import manager.*;
import static manager.CommonRes.*;


/**
 *
 * @author pc
 */
class ClientHandler extends Thread{

    private Socket client;
    private int ClientId;
    private String logid;
    private String clientName;
    private String loginTime;
    
    public ClientHandler(Socket client) {
        this.client=client;
        this.start();
    }
   
    private void login(ResultSet rs)throws Exception{
        //maintain client info locally ...
            this.loginTime= getCurrentTime();//Calendar.getInstance().toString();
            this.clientName=rs.getString("CLIENTNAME");

            //show in current status

            String message=rs.getString("CLIENTNAME") + " logged in at " + this.loginTime + "[" + this.client.getInetAddress().getHostAddress() + " ]";
            win.currentStatus.txt_area.append("\n" + message);

            //store in db log status
            String sql="insert into LoginTrans set CLIENTID=" + this.ClientId + ",IPADDRESS='" + this.client.getInetAddress().getHostAddress() + "',LOGINTIME='" + this.loginTime + "'";
            ConnectionFactory.setData(sql);

            //send info to all clients
            for(ClientDetails details:CommonRes.loggedInClients){
                ObjectOutputStream out=new ObjectOutputStream(details.client.getOutputStream());
                out.writeObject(ResponseCode.NEW_LOG);
                out.writeObject(this.ClientId);
                out.writeObject(this.clientName);
            }

            //add to collection of online clients
            ClientDetails details=new ClientDetails();
            details.clientId=this.ClientId;
            details.client=this.client;
            details.name=this.clientName;
            loggedInClients.add(details);
    }
    public void run(){
        try{
            while(running){
                ObjectInputStream in=new ObjectInputStream(this.client.getInputStream());
                RequestCode request=(RequestCode)in.readObject();
                if(request==RequestCode.LOGIN){
                    String logid=in.readObject().toString();
                    String pass=in.readObject().toString();
                    String sql="select * from ClientMaster where LOGINID='" + logid  + "' and PASSWORD='" + pass + "'";
                    ResultSet rs=ConnectionFactory.getData(sql);
                    ObjectOutputStream out=new ObjectOutputStream(this.client.getOutputStream());
                    if(rs.next()){
                        this.ClientId=rs.getInt("ID");
                        this.logid=logid;
                        //check if already logged in
                        if(rs.getInt("status")==0){
                            out.writeObject("Not verified");
                        }
                        if(rs.getInt("status")==1){
                            out.writeObject("Success");
                            this.login(rs);
                        }
                    }else{
                        out.writeObject("Failed");
                    }
                }
                if(request==RequestCode.VALIDATE_OTP){
                    String otp=in.readObject().toString();
                    String sql="select * from ClientMaster where ID=" + this.ClientId  + " and OTP=" + otp + "";
                    System.out.println(sql);
                    ResultSet rs=ConnectionFactory.getData(sql);
                    ObjectOutputStream out=new ObjectOutputStream(this.client.getOutputStream());
                    if(rs.next()){
                        out.writeObject("Success");
                        
                        this.login(rs);
                        sql="update ClientMaster set STATUS=1 where ID=" + this.ClientId;
                        ConnectionFactory.setData(sql);
                    }else{
                        out.writeObject("Failed");
                    }
                }
                if(request==RequestCode.LOGIN_ACK){
                    //sending login related details to new logged in client
                    ObjectOutputStream out=new ObjectOutputStream(this.client.getOutputStream());
                    out.writeObject(ResponseCode.LOGIN);
                    out.writeObject(CommonRes.loggedInClients.size()-1);
                    for(ClientDetails details:CommonRes.loggedInClients){
                        if(details.clientId!=this.ClientId){
                            out.writeObject(details.clientId);
                            out.writeObject(details.name);
                        }
                    }
                }
                if(request==RequestCode.CHAT_SEND){
                    Integer id=(Integer)in.readObject();
                    String msg=in.readObject().toString();
                    for(ClientDetails details:CommonRes.loggedInClients){
                        if(details.clientId==id){
                            ObjectOutputStream out=new ObjectOutputStream(details.client.getOutputStream());
                            out.writeObject(ResponseCode.CHAT_SEND);
                            out.writeObject(this.ClientId);
                            out.writeObject(CommonRes.getCurrentTime());
                            out.writeObject(msg);
                            break;
                        }
                    }
                }
                /*if(request==RequestCode.LOGIN){
                    
                }*/
            }
        }catch(Exception ex){
            trackException("Problem in ClientHandler : " + ex);
        }
    }
    
}
