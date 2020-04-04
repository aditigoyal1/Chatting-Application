/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.sql.*;
/**
 *
 * @author pc
 */
public class ConnectionFactory {
    public static ResultSet getData(String sql){
        ResultSet rs=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ShareDb","root","");
           Statement stmt=con.createStatement();
           rs=stmt.executeQuery(sql);
        }catch(Exception ex){
            CommonRes.trackException("SQL Exception in fetch :" + ex);
        }
        return rs;
    }
    
    public static int setData(String sql){
        int n=-1;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ShareDb","root","");
           Statement stmt=con.createStatement();
           n=stmt.executeUpdate(sql);
        }catch(Exception ex){
            CommonRes.trackException("SQL Exception in fetch :" + ex);
        }
        return n;
    }
}
