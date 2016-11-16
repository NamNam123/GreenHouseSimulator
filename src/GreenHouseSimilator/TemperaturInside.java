/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenHouseSimilator;

import java.util.Random;

/**
 *
 * @author Nam
 */
public class TemperaturInside {
    
    
    private int tempIn;
    Random random = new Random();
    

    public int getTemp() {
        return tempIn;
    }

    public void setTemp(int temp) {
        this.tempIn = temp;
    }

    public TemperaturInside() {
        tempIn = random.nextInt(5)+20;
    }

    @Override
    public String toString() {
        return "Temperatur{" + "temp=" + tempIn + '}';
    }
    
    
    
    
}
