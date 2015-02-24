/*
 *
 *
 */

package photoelectric_effect;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Electron{
    
    //attributes
    int x;
    int y;
    int xv=2;
    int yv=-2;
    int minx=0;
    int miny=40;
    int maxx=678;
    int maxy=557;
    
    double energy;
    
    Boolean release = false;
    
    public Electron(){
        
    }
    
    public Electron(int xPos, int yPos){
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
        release=true;
    }
    
    public Boolean getStatus(){
        return release;
    }
    
    public void calcEnergy(double hf, double wf, String units){
        if (y<376){ //adds a percentages of the work function to show range of kinetic energies
        }
        else if (y<432){
            wf=wf*1.05; //added 5% of original workfunction
        }
        else if(y<488){
            wf=wf*1.10; //added 10% of original workfunction
        }
        else if(y<544){
            wf=wf*1.15; //added 15% of original workfunction
        }
        else if(y<600){
            wf=wf*1.20; //added 20% of original workfunction
        }
        if (hf-wf >=0){
            energy=hf-wf;
            if (units=="MeV"){
                NumberFormat df = new DecimalFormat("###000.00");
                energy = Double.parseDouble(df.format(energy));
            }
            else if (units=="J"){
                DecimalFormat df = new DecimalFormat("0.000E0");
                energy = Double.parseDouble(df.format(energy));
            }
            
            changeStatus();
        }
    }
    
    public double getEnergy(){
        return energy;
    }
    
    public void Update(){
            x=x+xv;
            y=y+yv;
    }
    
}
