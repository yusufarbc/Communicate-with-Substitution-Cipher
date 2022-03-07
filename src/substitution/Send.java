
package substitution;


import java.io.*;
import java.net.*;


public class Send extends Thread{
    private String port;
    private String message;
    private String ip;

    public Send(String port, String ip, String message) {
        this.port = port;
        this.message = message;
        this.ip = ip;
        try {
            Socket s=new Socket(ip,Integer.valueOf(port));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message);  
            dout.flush();  
            dout.close();  
            s.close();
        } catch (Exception ex){System.out.println(ex);}    }   
    public void run() {

    }
}


 

