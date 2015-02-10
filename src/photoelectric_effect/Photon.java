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
    int xv=2;
    int yv=2;
    int minx=0;
    int miny=0;
    int maxx=600;
    int maxy=600;
    
    int PhoRed=199;
    int PhoBlue=0;
    int PhoGreen=99;
    
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
    
    public void Boundaries(){
        if (x==maxx){
            x=0;
            y=0;
        }
        if (y==maxy){
            y=0;
            x=0;
        }
    }
    
    public void Collide(){
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
