/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouse_BatchController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nam
 */
public class BC_Receiver {
        public final static int TCPSocket_Config = 12345;      // you may change this
    public final static String SERVER = "localhost";  // localhost
   // public final static String FILE_TO_RECEIVED = "c:/test1.xml";  // you may change this, I give a
 public final static int LAST_INDEX_OF_BYTE = 10;  
    
    public static void main(String[] args) throws IOException {

     Socket socket = null;
 InputStream is=null;
 OutputStream out=null;
            @SuppressWarnings("resource")
            ServerSocket server = new ServerSocket(TCPSocket_Config);
           
            while (true) {

                System.out.println("Waiting for connection # on port " + TCPSocket_Config);
                 socket = server.accept();
                 
               
                System.out.println("client accepted");
                 is = socket.getInputStream();
               out = socket.getOutputStream();
                System.out.println("imputstream");
                
                
           



    byte b[] = new byte[2000];

 is.read(b);

    String date = new String(b);

    int temp = date.lastIndexOf(LAST_INDEX_OF_BYTE);

                //System.out.println(temp);
       // Convert the array to a base 64 sring.
  

    System.out.println("Server said: "+date);
                System.out.println(date.length() +"date lenght");
    
    try {
    BufferedWriter bout = new BufferedWriter(new FileWriter("receivedRecipe6.xml"));
   
    
    bout.write(date,0,temp);  //Replace with the string 
                                             //you are trying to write  
    bout.close();
}
catch (IOException e)
{
    System.out.println("Exception ");

}
    
    }

                
//                 String word="";
//                byte[] buffer = new byte[1024];
//               try{
//
//    ByteArrayOutputStream serverinput=new ByteArrayOutputStream();
// int len=0;
//byte[] buf=new byte[1000];
//        while ((len = in.read(buf))>=0) {
//              serverinput.write(buf, 0, len);
//
//        }
//
//      socket.shutdownInput();
//
//        word=new String(serverinput.toByteArray());
//    System.out.println("Client send 1"+word);
//
//    }catch(Exception e){
//      System.out.println(e.getMessage());
  }


}
