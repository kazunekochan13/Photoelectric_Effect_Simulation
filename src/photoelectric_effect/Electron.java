/*
 *
 *
 */

package photoelectric_effect;

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
    
    public void calcEnergy(double hf, double wf, String wave){
        if (y<376){
        }
        else if (y<432){
            wf=wf*1.05; //added 1% of original workfunction
        }
        else if(y<488){
            wf=wf*1.10;
        }
        else if(y<544){
            wf=wf*1.15;
        }
        else if(y<600){
            wf=wf*1.20;
        }
        if (hf-wf >=0){
            energy=hf-wf;
            if (wave=="Red" || wave=="Blue"){
                energy = Double.parseDouble(String.format("%.3g%n", energy));
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
