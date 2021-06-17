/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author try
 */
public class Server {
    
    /*   public Server() throws IOException{
    MyServer();
    }*/
    
    private thred a;
    
 public void MyServer() throws IOException{
        // TODO code application logic here
        ServerSocket ss = null;
         try {
            ss = new ServerSocket(130);
        } catch (Exception e) {
            System.err.println("not working");
        }
         
        Socket socket1, socket2; 
         while (true) {         
         socket1=ss.accept();
         socket2=ss.accept();
         
         /*classSerlizition cs = new classSerlizition();
         cs.a = 1;*/
         
         /*ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
         out1.writeObject(cs);
         ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
         out1.writeObject(cs);*/
                
         a = new thred(socket1,socket2);
         a.start();
         
     }
    }
}
