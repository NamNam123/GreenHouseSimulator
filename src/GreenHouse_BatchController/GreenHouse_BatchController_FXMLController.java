/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouse_BatchController;

import GreenHouseSimilator.GreenHouseAutoSERVER;
import GreenhouseAPI.Greenhouse;
import GreenhouseAPI.IGreenhouse;
import PLCCommunication.PLCConnection;
import PLCCommunication.UDPConnection;
import com.jfoenix.controls.JFXButton;
import java.awt.Color;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nam
 */
public class GreenHouse_BatchController_FXMLController implements Initializable {

    @FXML
    private TextField orderID;
    @FXML
    private TextField port;
    @FXML
    private TextField ipAddresse;
    @FXML
    private TextField greenHouseID;
    @FXML
    private TextField startDate;
    @FXML
    private TextField endDate;
    @FXML
    private TextField minTemp;
    @FXML
    private TextField maxTemp;
    @FXML
    private TextField maxWaterLevel;
    @FXML
    private TextField minWaterLevel;
    @FXML
    private TextField maxMoist;
    @FXML
    private TextField minMoist;
    @FXML
    private TextField maxBlueLight;
    @FXML
    private TextField minBlueLight;
    @FXML
    private TextField setTemp;
    @FXML
    private TextField setWaterLevel;
    @FXML
    private TextField setBlueLight;
    @FXML
    private TextField maxRedLight;
    @FXML
    private TextField minRedLight;
    @FXML
    private TextField setRedLight;
    @FXML
    private TextField setFanSpeed;
    @FXML
    private JFXButton createRecipt;
    @FXML
    private TextField setPlantHeight;
    @FXML
    private JFXButton createNewRecipe;

    Recipe recipe;
    @FXML
    private TextField setMoist;
//
//    PLCConnection con = new UDPConnection(54000, "localhost"); //local host
//  IGreenhouse greenHouseAPI = new Greenhouse(con);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        createNewRecipe.setVisible(false);

    }

    @FXML
    private void createRecipt(ActionEvent event) throws FileNotFoundException {
        if (createRecipt.getText().equalsIgnoreCase("create recipe")) {
            createRecipt.setText("Recipe created");
            createRecipt.setStyle("-fx-background-color:green");
            createNewRecipe.setVisible(true);

            int greenHouseid = new Integer(greenHouseID.getText());
            int orderid = new Integer(orderID.getText());
            int portid = new Integer(port.getText());
            String ipAdresseid = ipAddresse.getText();
            String startDateid = startDate.getText();
            String endDateid = endDate.getText();
            int maxTempid = new Integer(maxTemp.getText());
            int minTempid = new Integer(minTemp.getText());
            int setTempid = new Integer(setTemp.getText());
            int maxWaterLevelid = new Integer(maxWaterLevel.getText());
            int minWaterLevelid = new Integer(minWaterLevel.getText());
            int setWaterLevelid = new Integer(setWaterLevel.getText());
            int maxMoistid = new Integer(maxMoist.getText());
            int minMoistid = new Integer(minMoist.getText());
            int setMoistid = new Integer(setMoist.getText());
            int maxBlueLightid = new Integer(maxBlueLight.getText());
            int minBlueLightid = new Integer(minBlueLight.getText());
            int setBlueLightid = new Integer(setBlueLight.getText());
            int maxRedLightid = new Integer(maxRedLight.getText());
            int minRedLightid = new Integer(minRedLight.getText());
            int setRedLightid = new Integer(setRedLight.getText());
            int setFanSpeedid = new Integer(setFanSpeed.getText());
            int setPlantHeightid = new Integer(setPlantHeight.getText());
           
          Recipe r = new Recipe();
             r.setOrderID(orderid);
          r.setEndDate(endDateid);
          r.setGreenHouseID(greenHouseid); // ???
           r.setPort(portid);//??
          r.setIpAdresse(ipAdresseid);//??
          r.setMaxBlueLight(maxBlueLightid);
          r.setMaxMoist(maxMoistid);
          r.setMaxRedLight(maxRedLightid);
          r.setMaxTemp(maxTempid);
          r.setMaxWaterLevel(maxWaterLevelid);
          r.setMinBlueLight(minBlueLightid);
          r.setMinMoist(minMoistid);
          r.setMinRedLight(minRedLightid);
          r.setMinTemp(minTempid);
          r.setMinWaterLevel(minWaterLevelid);
          r.setSetBlueLight(setBlueLightid);
          r.setSetFanSpeed(setFanSpeedid);
          r.setSetMoist(setMoistid);
          r.setSetPlantHeight(setPlantHeightid);
          r.setSetRedLight(setRedLightid);
          r.setSetTemp(setTempid);
          r.setSetWaterLevel(setWaterLevelid);
          
          
//            greenHouseAPI.SetBlueLight(setBlueLightid);
//                 serializeToXML(r);
//            
      // recipe = new Recipe(greenHouseid, orderid, portid, ipAdresseid, startDateid, endDateid, maxTempid, minTempid, setTempid, maxWaterLevelid, minWaterLevelid, setWaterLevelid, maxMoistid, minMoistid, setMoistid, maxBlueLightid, minBlueLightid, setBlueLightid, maxRedLightid, minRedLightid, setRedLightid, setFanSpeedid, setPlantHeightid);
        // System.out.println("new recipe added to greenhouse with id: " + greenHouseid);
    System.out.println(recipe);
//           
   // greenHouseAPI.SetRedLight(recipe.getSetRedLight());
//            
        serializeToXML(r);
        
        }
    }

    @FXML
    private void createNewRecipe(ActionEvent event) {
        createRecipt.setText("create recipe");
        createRecipt.setStyle("-fx-background-color:yellow");
        createNewRecipe.setVisible(false);

        orderID.clear();
        port.clear();
        ipAddresse.clear();
        greenHouseID.clear();
        startDate.clear();
        endDate.clear();
        minTemp.clear();
        maxTemp.clear();
        maxWaterLevel.clear();
        minWaterLevel.clear();
        maxMoist.clear();
        minMoist.clear();
        maxBlueLight.clear();
        minBlueLight.clear();
        setTemp.clear();
        setWaterLevel.clear();
        setBlueLight.clear();
        maxRedLight.clear();
        minRedLight.clear();
        setRedLight.clear();
        setFanSpeed.clear();

        setPlantHeight.clear();
    }

    public void serializeToXML(Recipe theCipe) throws FileNotFoundException {
        FileOutputStream fileOs = new FileOutputStream("TheFirstRecipeEver.xml",false);
        try (XMLEncoder xe1 = new XMLEncoder(fileOs)) {
            xe1.writeObject(theCipe);
            System.out.println("recipe created");
            xe1.flush();
            xe1.close();
        }

    }

}
