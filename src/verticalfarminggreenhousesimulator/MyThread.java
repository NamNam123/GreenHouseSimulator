/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verticalfarminggreenhousesimulator;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import static verticalfarminggreenhousesimulator.VerticalFarmingGreenHouseSERVER.state;


/**
 *
 * @author Nam
 */
public class MyThread implements Runnable{

      String musicFile = "src/sounds/alarm.mp3";
  Media sound = new Media(new File(musicFile).toURI().toString());
  MediaPlayer mediaPlayer = new MediaPlayer(sound);
    public MyThread() {
    }
    
        private void alarmStart() {
        
        Color co = new Color(1.0, 0.0, 0.0, 1.0);
      
       mediaPlayer.setVolume(0.5);
    mediaPlayer.play();
    }
    
            private void alarmStop() {
        
       // Color co = new Color(1.0, 0.0, 0.0, 1.0);
      
       mediaPlayer.setVolume(0.5);
    mediaPlayer.stop();
    }
    public void sleep() throws InterruptedException
    {
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        Color co = new Color(1.0, 0.0, 0.0, 1.0);
        boolean run = true;
        int counter =0;
     while(run)
     {
         
         switch(state)
             
         {
             case 0: alarmStop();
             break;
             case 1: alarmStart();
             break;
             
         }
         System.out.println("tester");
         try {
             
         
             sleep();
             counter++;
             
             if(counter ==5)
             {
                 run =false;
             }
         } catch (InterruptedException ex) {
             Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }
    
    
}
