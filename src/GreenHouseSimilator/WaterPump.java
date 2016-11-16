/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouseSimilator;

/**
 *
 * @author Nam
 */
public class WaterPump {
    private double waterLevel =10;
    private int waterPump = 120;
    

    public double getWaterLevel() {
        return waterLevel;
    }

    public void addWaterLevel(int seconds){
        for (int i = 0; i < seconds; i++) {
            
            try {
                waterLevel += 0.083333333333;
                System.out.println("waterLevel: " + waterLevel/10 + " cm " +  "     seconds " + i );
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String toString() {
        return "WaterPump{" + "waterAmount added: " + waterLevel + " Liter"+'}';
    }
    
    
    
   
    
    
}
