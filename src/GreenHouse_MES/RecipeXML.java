/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouse_MES;


import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Nam
 */
public class RecipeXML {
    
      private int greenHouseID;
    private int orderID;
    private int port;
    private String ipAdresse;
    private String startDate;
    private String endDate;
    private int maxTemp;
    private int minTemp;
    private int setTemp;
    private int maxWaterLevel;
    private int minWaterLevel;
    private int setWaterLevel;
    private int maxMoist;
    private int minMoist;
    private int setMoist;
    private int maxBlueLight;
    private int minBlueLight;
    private int setBlueLight;
    private int maxRedLight;
    private int minRedLight;
    private int setRedLight;
    private int setFanSpeed;
    private int setPlantHeight;

      public RecipeXML()
      {
          
      }
   
    public RecipeXML(
            int greenHouseID, 
            int orderID, 
            int port,
            String ipAdresse, 
            String startDate,
            String endDate, 
            int maxTemp, 
            int minTemp, 
            int setTemp, 
            int maxWaterLevel,
            int minWaterLevel, 
            int setWaterLevel, int maxMoist,
            int minMoist,
            int setMoist,
            int maxBlueLight, 
            int minBlueLight, 
            int setBlueLight, 
            int maxRedLight,
            int minRedLight, 
            int setRedLight, 
            int setFanSpeed, 
            int setPlantHeight) 
    {
        this.greenHouseID = greenHouseID;
        this.orderID = orderID;
        this.port = port;
        this.ipAdresse = ipAdresse;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.setTemp = setTemp;
        this.maxWaterLevel = maxWaterLevel;
        this.minWaterLevel = minWaterLevel;
        this.setWaterLevel = setWaterLevel;
        this.maxMoist = maxMoist;
        this.minMoist = minMoist;
        this.setMoist = setMoist;
        this.maxBlueLight = maxBlueLight;
        this.minBlueLight = minBlueLight;
        this.setBlueLight = setBlueLight;
        this.maxRedLight = maxRedLight;
        this.minRedLight = minRedLight;
        this.setRedLight = setRedLight;
        this.setFanSpeed = setFanSpeed;
        this.setPlantHeight = setPlantHeight;
    }
    
    
    
    
    

    public int getGreenHouseID() {
        return greenHouseID;
    }

    public void setGreenHouseID(int greenHouseID) {
        this.greenHouseID = greenHouseID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getTemp() {
        return setTemp;
    }

    public void setTemp(int setTemp) {
        this.setTemp = setTemp;
    }

    public int getMaxWaterLevel() {
        return maxWaterLevel;
    }

    public void setMaxWaterLevel(int maxWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
    }

    public int getMinWaterLevel() {
        return minWaterLevel;
    }

    public void setMinWaterLevel(int minWaterLevel) {
        this.minWaterLevel = minWaterLevel;
    }

    public int getWaterLevel() {
        return setWaterLevel;
    }

    public void setWaterLevel(int setWaterLevel) {
        this.setWaterLevel = setWaterLevel;
    }

    public int getMaxMoist() {
        return maxMoist;
    }

    public void setMaxMoist(int maxMoist) {
        this.maxMoist = maxMoist;
    }

    public int getMinMoist() {
        return minMoist;
    }

    public void setMinMoist(int minMoist) {
        this.minMoist = minMoist;
    }

    public int getMoist() {
        return setMoist;
    }

    public void setMoist(int setMoist) {
        this.setMoist = setMoist;
    }

    public int getMaxBlueLight() {
        return maxBlueLight;
    }

    public void setMaxBlueLight(int maxBlueLight) {
        this.maxBlueLight = maxBlueLight;
    }

    public int getMinBlueLight() {
        return minBlueLight;
    }

    public void setMinBlueLight(int minBlueLight) {
        this.minBlueLight = minBlueLight;
    }

    public int getBlueLight() {
        return setBlueLight;
    }

    public void setBlueLight(int setBlueLight) {
        this.setBlueLight = setBlueLight;
    }

    public int getMaxRedLight() {
        return maxRedLight;
    }

    public void setMaxRedLight(int maxRedLight) {
        this.maxRedLight = maxRedLight;
    }

    public int getMinRedLight() {
        return minRedLight;
    }

    public void setMinRedLight(int minRedLight) {
        this.minRedLight = minRedLight;
    }

    public int getRedLight() {
        return setRedLight;
    }

    public void setRedLight(int setRedLight) {
        this.setRedLight = setRedLight;
    }

    public int getFanSpeed() {
        return setFanSpeed;
    }

    public void setFanSpeed(int setFanSpeed) {
        this.setFanSpeed = setFanSpeed;
    }

    public int getPlantHeight() {
        return setPlantHeight;
    }

    public void setPlantHeight(int setPlantHeight) {
        this.setPlantHeight = setPlantHeight;
    }

    @Override
    public String toString() {
        return "Recipe" + "\n greenHouseID = " + greenHouseID +
                "\n orderID = " + orderID + 
                "\n port = " + port + 
                "\n ipAdresse = " + ipAdresse +
                "\n startDate = " + startDate +
                "\n endDate = " + endDate 
                + "\n maxTemp = " + maxTemp +
                "\n minTemp = " + minTemp + 
                "\n setTemp = " + setTemp + 
                "\n maxWaterLevel = " + maxWaterLevel +
                "\n minWaterLevel = " + minWaterLevel + 
                "\n setWaterLevel = " + setWaterLevel + 
                "\n maxMoist = " + maxMoist + 
                "\n minMoist = " + minMoist +
                "\n setMoist = " + setMoist + 
                "\n maxBlueLight = " + maxBlueLight +
                "\n minBlueLight = " + minBlueLight +
                "\n setBlueLight = " + setBlueLight + 
                "\n maxRedLight = " + maxRedLight +
                "\n minRedLight = " + minRedLight +
                "\n setRedLight = " + setRedLight +
                "\n setFanSpeed = " + setFanSpeed + 
                "\n setPlantHeight = " + setPlantHeight;
    }
    
   
     public void serializeToXML(RecipeXML theCipe) throws FileNotFoundException {
        FileOutputStream fileOs = new FileOutputStream("recipeTest.xml",false);
        try (XMLEncoder xe1 = new XMLEncoder(fileOs)) {
            xe1.writeObject(theCipe);
            System.out.println("recipe created");
            xe1.flush();
            xe1.close();
        }
     }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        RecipeXML rp = new RecipeXML();
        rp.setBlueLight(100);
        rp.setMaxTemp(25);
        rp.serializeToXML(rp);
    
}
}