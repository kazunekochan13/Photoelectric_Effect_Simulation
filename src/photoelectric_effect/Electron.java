/*
 *
 *
 */

package photoelectric_effect;

public class Electron{
    
    //attributes
    int x;
    int y;
    int xv=2;//(int)Math.floor(Math.random()*5)+1;
    int yv=-2;//(int)Math.floor(Math.random()*5)+1;
    int minx=0;
    int miny=0;
    int maxx=678;
    int maxy=557;
    
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
    
    public Boolean returnStatus(){
        return release;
    }
    
    public void Absorb(int photonX, int photonY){
        int radii;
        int distanceA;
        int distanceB;
        distanceA = ((x+10)-(photonX+3));//how far apart on the x-axis the centre of the circles are
        distanceB = ((y+10)-(photonY+3));//how far apart on the y-axis the centre of the circles are
        radii = (((distanceA)^2)+((distanceB)^2))^(1/2);
        if (radii<=(13)){
            release=true;
        }
    }
    
    public void Update(){
        
        
            x=x+xv;
            y=y+yv;
        
    }
    
}
