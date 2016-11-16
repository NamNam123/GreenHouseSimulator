/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verticalfarminggreenhousesimulator;


import GreenhouseAPI.Greenhouse;
import GreenhouseAPI.IGreenhouse;
import PLCCommunication.PLCConnection;
import PLCCommunication.UDPConnection;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javax.swing.JFrame;
import javafx.scene.media.MediaPlayer;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Background;
import javafx.util.Duration;
/**
 *
 * @author Nam
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane pane;
  
    @FXML
   private Circle light;

 
    @FXML
    private TextField setLightLevel;
    @FXML
    private Slider waterSliderLevel;
    @FXML
    private Button addWater;
    @FXML
    private TextField inTemp;
    @FXML
    private TextField outTemp;
    @FXML
    private AnchorPane Tab1;
    
    @FXML
    private Circle alarmStatus;
    private Button alarmButton;
    
        @FXML
    private JFXButton jfxbutton;

 //VerticalFarmingGreenHouseSimulator greenHouse = new VerticalFarmingGreenHouseSimulator();
    @FXML
    private Button checkInsideTemp;
    
    //PLCConnection con = new UDPConnection(5000, "192.168.0.10"); // Til Kassen i rummet
    
   PLCConnection con = new UDPConnection(54000, "localhost"); //local host
      IGreenhouse greenHouseAPI = new Greenhouse(con);
    @FXML
    private Button checkOutsideTemp;
    @FXML
    private Button setIndsideTemp;
    @FXML
    private TextField setIndsideTempTxArea;
    @FXML
    private TextField addWaterLevelTeaxArea;
    @FXML
    private Button checkwater;

    TranslateTransition trans = new TranslateTransition();
       
     TranslateTransition trans2 = new TranslateTransition();
    @FXML
    private Button start;
    @FXML
    private Button blueLight;
    @FXML
    private Button redLight;
   // @Override
    
    
       String musicFile = "src/sounds/alarm.mp3";
  Media sound = new Media(new File(musicFile).toURI().toString());
  MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     
        String color = "#ffcc00";
       pane.setStyle("-fx-background-color: Black");
       
//       waterSliderLevel.setMax();
//     
       waterSliderLevel.setValue(0);
 
       //waterSliderLevel.setVisible(false);
     alarmStatus.setVisible(false);
       light.setVisible(false);
      
      
//      trans.setToY(-200);
//         //trans.setToX(-100);
//         trans.setAutoReverse(true);
//         trans.setCycleCount(100);

trans.setDuration(Duration.seconds(4));
       trans.setNode(jfxbutton);
       
       //trans2.setDuration(Duration.seconds(4));
      // trans2.setNode(waterSliderLevel);
    
    }



//    private void lightOn(ActionEvent event) {
//        light.setStyle("-fx-background-color: Red");
//          //String color = "#4300ff";
//      
//      // light.setStyle("-fx-background-color: " +color);
//        light.setVisible(true);
//    }
//
//    private void lightOff(ActionEvent event) {
//        
//       
//    
//        // Color co = new Color(1.0, 0.0, 0.0, 1.0);
//    alarmStatus.setVisible(true);
//    alarmStatus.setStyle("-fx-background-color: Red");
//   
//    
//    
//         //light.setVisible(false);
//    }  

  
    
    private void alarm() {
        
        
        
        
        Color co = new Color(1.0, 0.0, 0.0, 1.0);
          alarmStatus.setStyle("-fx-background-color: red");
       alarmStatus.setVisible(true);
      mediaPlayer.setVolume(0.5);
   mediaPlayer.play();
System.out.println("alarmmmmmmmming");
       
    }
    

    private void alarmButton(ActionEvent event) throws InterruptedException {
          Color co = new Color(1.0, 0.0, 0.0, 1.0);
 if(alarmButton.getText().equals("Alarm"))
 {
     VerticalFarmingGreenHouseSERVER.state = 1;
     alarmButton.setText("Stop alarm");
 }
 
  if(alarmButton.getText().equals("Stop alarm"))
 {
     VerticalFarmingGreenHouseSERVER.state = 0;
          alarmButton.setText("Alarm");
     
 }
 
 
 
 //alarmButton.setText("Stop alarm");
   //  alarmStatus.setFill(co);
          // alarmStatus.setVisible(true);
   boolean run = true;
        int counter =0;
    
   }

    @FXML
    private void jfxbuttonAction(ActionEvent event) {
    }

    @FXML
    private void checkInsideTemp(ActionEvent event) {
      
               double temp =  greenHouseAPI.ReadTemp1()-273;
            inTemp.setText(String.valueOf(temp) + "°C");
            
            if(temp>25)
            {
                alarm();
            }
            
            else if(temp<=25)
            {
                mediaPlayer.stop();
                //alarmButton.setStyle("-fx-background-color: green");
            }
             
   
       
    }
    
    

    @FXML
    private void checkOutsideTemp(ActionEvent event) {
       
      
            
               double temp =  greenHouseAPI.ReadTemp2()-273;
            outTemp.setText(String.valueOf(temp) + "°C");
      
    }

    @FXML
    private void setIndsideTemp(ActionEvent event) {
        int temp = Integer.parseInt(setIndsideTempTxArea.getText());
         System.out.println(temp);
        //greenHouseAPI.SetTemperature(new Integer(setIndsideTempTxArea.getText()+273));
         greenHouseAPI.SetTemperature(273+temp);
       
    }
    
      @FXML
    private void addWater(ActionEvent event) {
        int seconds = Integer.parseInt(addWaterLevelTeaxArea.getText());
       
        // seconds = Double.parseDouble(addWaterLevelTeaxArea.getText());
           System.out.println("adding water for " + seconds  +"  seconds");
           
           greenHouseAPI.AddWater(seconds);
        
        
       
    }

    @FXML
    private void checkwater(ActionEvent event) {
       double temp = greenHouseAPI.ReadWaterLevel();
         
          double temp2 = temp*1.48076923077;
        
          
      //   waterSliderLevel.setValue(temp2);
        
        // trans2.play();
               trans.setToY(-temp2);
               
                 Color co = new Color(1.0, 0.0, 0.0, 1.0);
               
              
                   trans.play();
                   
              
             
//         //trans.setToX(-100);
//         trans.setAutoReverse(true);
//         trans.setCycleCount(100);
    }

    @FXML
    private void start(ActionEvent event) {
        
           double temp =  greenHouseAPI.ReadTemp1()-273;
            inTemp.setText(String.valueOf(temp) + "°C");
            
             double temp1 =  greenHouseAPI.ReadTemp2()-273;
            outTemp.setText(String.valueOf(temp1) + "°C");
            
            
            
             double temp3 = greenHouseAPI.ReadWaterLevel();
         
          double temp2 = temp3*1.48076923077;
        
          
      //   waterSliderLevel.setValue(temp2);
        
        // trans2.play();
               trans.setToY(-temp2);
               
                 Color co = new Color(1.0, 0.0, 0.0, 1.0);
               
              
                   trans.play();
    }

    @FXML
    private void blueLight(ActionEvent event) {
       // greenHouseAPI.SetBlueLight(100);
       
        if(blueLight.getText().equalsIgnoreCase("BlueOn"))
        {
            greenHouseAPI.SetBlueLight(0);
            blueLight.setText("Blue");
            light.setStyle("-fx-background-color: Black");
        }
        else if(blueLight.getText().equals("Blue"))
        {
           greenHouseAPI.SetBlueLight(100);
            blueLight.setText("BlueOn");
            
            light.setStyle("-fx-background-color: Blue");
        }
    }

    @FXML
    private void redLight(ActionEvent event) {
        if(redLight.getText().equalsIgnoreCase("RedOn"))
        {
            greenHouseAPI.SetRedLight(0);
            redLight.setText("Red");
               light.setStyle("-fx-background-color: Black");
        }
        else if(redLight.getText().equals("Red"))
        {
           greenHouseAPI.SetRedLight(100);
            redLight.setText("RedOn");
              light.setStyle("-fx-background-color: Red");
        }
    }
    
}
