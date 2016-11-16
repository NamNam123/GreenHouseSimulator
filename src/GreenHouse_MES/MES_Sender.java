/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouse_MES;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam
 */
public class MES_Sender {
       public static final int BatchController_PORT = 12345; // socket

  public final static String FILE_TO_SEND = "r1.xml";  // you may change this
   
   
     
    public static void main(String[] args) throws IOException {
       
    

      



 

     //file that is the xml file
    
 

   

          

     //connect to server

   String hostname = JOptionPane.showInputDialog("Server name?","localhost");

        Socket socket = new Socket(hostname,BatchController_PORT);
             System.out.println("You are now connected with server at port " + BatchController_PORT);

        
        try {
             Path path = Paths.get("recipe.xml");
             
             byte[] data = Files.readAllBytes(path);
            
               
              // Integer temp = data.length;
         
             //String d = Integer.toString(temp);
             
             String text = Arrays.toString(data);
             System.out.println(text);
             
             
             
       
             
       try (OutputStream os = socket.getOutputStream()) {
           System.out.println(" sending");
           // os.write(data);
           
           //os.write(send);
          
           os.write(data);
           System.out.println(" sending done");
           System.out.println("datasize " + data.length);
           
           
           
           os.flush();
           os.close();
       }
       // os.write(data);
        }
        
        
        catch (FileNotFoundException e) {
            
            System.out.println("file not founded");
        

        }

    }
}
