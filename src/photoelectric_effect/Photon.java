/*
 *
 *
 */

package photoelectric_effect;

import java.awt.*;
import javax.swing.JPanel;
import java.lang.Math;


public class Photon{
    
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
    
    String name;
    double joules; //only used the average of the energy range in both joules and MeV
    double MeV;
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
    
    public double getHf(int emRegion){
        switch (emRegion){
            case 1:
                name="Radiowaves";
                joules=1.99E-24;
                MeV=1.24E-5; break;
            case 2:
                name="Microwaves";
                joules=1.00E-22;
                MeV=6.28E-4; break;
            case 3:
                name="Infrared radiation";
                joules=1.42E-19;
                MeV=8.89E-1; break;
            case 4:
                name="Visible light";
                joules=3.91E-19;
                MeV=2.44; break;
            case 5:
                name="UltraViolet";
                joules=1.02E-17;
                MeV=6.37E1; break;
            case 6:
                name="X-Rays";
                joules=9.95E-15;
                MeV=6.22E4; break;
            case 7:
                name="Gamma rays";
                joules=1.99E-14;
                MeV=1.24E5; break;
        }
        return joules;
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
    
    public void Energy(int metalNo){
        
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
