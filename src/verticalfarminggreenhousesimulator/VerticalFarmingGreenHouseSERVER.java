/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verticalfarminggreenhousesimulator;

import GreenHouseSimilator.GreenHouseAutoSERVER;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nam
 */
public class VerticalFarmingGreenHouseSERVER extends Application {
    
       GreenHouseAutoSERVER ghA = null;
         
    public static int state =0;
    
    Thread masterThread = new Thread(ghA = new GreenHouseAutoSERVER(1));
    
    @Override
    public void start(Stage stage) throws Exception {
     
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        System.out.println("Starting greenHouseAuto nr: "+ghA.getGreenHouseID());
        masterThread.start();
    
       
        
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        launch(args);
//         MyThread t1 = new MyThread();
//         Thread masterThread = new Thread(t1);
//        masterThread.start();


         

    }
    
}
