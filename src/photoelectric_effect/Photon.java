/*
 *
 *
 */

package photoelectric_effect;

import java.awt.*;
import java.lang.Math;
import java.util.Random;
import javax.swing.JPanel;


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
    
    double joules=1.99E-22; //only used the average of the energy range in both joules and MeV
    double MeV=1.24E-5;
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
    
    public void getHf(String emRegion, String Units){
        Random r = new Random();
        switch (emRegion){
            case "Radiowaves":
                joules=r.nextDouble()*1.99E-22;
                MeV=r.nextDouble()*1.24E-5; break;
            case "Microwaves":
                joules=(r.nextDouble()*((1.99E-22)-(1.99E-24)))+1.99E-24;
                MeV=(r.nextDouble()*((1.24E-3)-(1.24E-5)))+1.24E-5; break;
            case "Infrared":
                joules=(r.nextDouble()*((2.84E-19)-(1.99E-22)))+1.99E-22;
                MeV=(r.nextDouble()*((1.78)-(1.24E-3)))+1.24E-3; break;
            case "Visible":
                joules=(r.nextDouble()*((4.9E-19)-(2.84E-19)))+2.84E-19;
                MeV=(r.nextDouble()*((3.11)-(1.78)))+1.78; break;
            case "UltraViolet":
                joules=(r.nextDouble()*((1.99E-17)-(4.97E-19)))+4.97E-19;
                MeV=(r.nextDouble()*((1.24E2)-(3.11)))+3.11; break;
            case "X-Rays":
                joules=(r.nextDouble()*((1.99E-14)-(1.99E-17)))+1.99E-17;
                MeV=(r.nextDouble()*((1.24E5)-(1.24E2)))+1.24E2; break;
            case "Gamma":
                joules=(r.nextDouble()*((1.99E-11)-(1.99E-14)))+1.99E-14;
                MeV=(r.nextDouble()*((1.24E7)-(1.24E5)))+1.24E5; break;
        }
    }
    
    public double getEnergy(String units){
        if (units=="J"){
            return joules;
        }
        else{
            return MeV;
        }
    }
    
    public double getJoules(){
        return joules;
    }
    
    public double getMeV(){
        return MeV;
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
