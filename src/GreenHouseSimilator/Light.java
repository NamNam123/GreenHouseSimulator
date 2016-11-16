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
public class Light {

    private int level = 0;
    private String color = null;
    
    static final String COLOR1 = "Red";
    static final String COLOR2 = "Blue";

    public Light() {

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setColor(String color) {
       this.color = color;
       
        
        

    }


    @Override
    public String toString() {
        return "Light{" + "level=" + level + ", color=" + color ;
    }

}
