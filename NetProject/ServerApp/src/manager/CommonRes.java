
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import serverapp.ServerWin;

/**
 *
 * @author pc
 */
public class CommonRes {
    public static boolean _DEBUG=true;
    public static boolean running=false;
    public static ServerWin win;
    public static ArrayList<ClientDetails> loggedInClients;
    public static void trackException(String message){
         if(_DEBUG){
                JOptionPane.showMessageDialog(win, message,"Server Side Exception",JOptionPane.ERROR_MESSAGE);
            }else{
                //maintain log file
            }
    }
    public static String getCurrentTime(){
        Calendar calendar=Calendar.getInstance();
        String time=calendar.get(Calendar.DATE) + "/" +
                    (calendar.get(Calendar.MONTH) + 1 ) + "/" +
                    calendar.get(Calendar.YEAR) + " | " +
                    calendar.get(Calendar.HOUR) + ":" +
                    calendar.get(Calendar.MINUTE) + ":" +
                    calendar.get(Calendar.SECOND) ;
        return time;
        
    }
}
