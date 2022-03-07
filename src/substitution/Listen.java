
package substitution;

import java.io.*;
import java.net.*;

public class Listen extends Thread{
    private String message;
    private String port;

    public Listen(String port) {
        this.port = port;
        try {
            ServerSocket ss=new ServerSocket(Integer.valueOf(port));
            Socket s=ss.accept();//establishes connection 
            DataInputStream dis = new DataInputStream(s.getInputStream());
            message = new String(dis.readUTF());  
            dis.close();
            s.close();  
            ss.close();
        } catch (Exception ex) {System.out.println(ex); }        
    }

    @Override
    public void run() {

    }
    
    public String getMessage() {
        return message;
    }
    
}
