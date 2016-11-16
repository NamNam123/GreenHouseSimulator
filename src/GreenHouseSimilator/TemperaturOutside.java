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
public class TemperaturOutside {
     Random random = new Random();
    private int tempOut;
    
      public TemperaturOutside() {
       tempOut = random.nextInt(10)+10;
    }
    
    public int getTemp() {
        return tempOut;
    }

  

  



    @Override
    public String toString() {
        return "Temperatur{" + "temp=" + tempOut + '}';
    }
    
    
}
