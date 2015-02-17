/*
 *
 *
 */

package photoelectric_effect;

import java.awt.*;
import javax.swing.JPanel;
import java.lang.Math;


public class Photon extends JPanel{
    
    //attributes
    int x=50;
    int y=50;
    int xv=1;
    int yv=3;
    int minx=0;
    int miny=40;
    int maxx=678;
    int maxy=557;
    
    int PhoRed=199;
    int PhoBlue=0;
    int PhoGreen=99;
    
    double hf;
    Boolean absorb=false;
    
    public Photon(){
        
    }
    
    public Photon(int xPos, int yPos){
        x=xPos;
        y=yPos;
    }
    
    public int getxPos(){
        return x;
    }
    
    public int getyPos(){
        return y;
    }
    
    public String readX(){
        return String.valueOf(x);
    }
    
    public String readY(){
        return String.valueOf(y);
    }
    public void changeStatus(){
        absorb=true;
    }
    
    public Boolean getStatus(){
        return absorb;
    }
    
    public void Energy(String metal){
        
    }
    
    public void Move(){
        if (absorb==false){
            if (x<minx) {
                xv=-xv;
            }
            if (x>maxx){
                xv=-xv;
            }
            if (y<miny) {
                yv=-yv;
            }
            if (y>maxy){
                yv=-yv;
            }
            x=x+xv;
            y=y+yv;
        }
    }
        
    
}
