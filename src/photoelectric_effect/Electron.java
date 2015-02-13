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
    
    public void changeStatus(){
        release=true;
    }
    
    public Boolean getStatus(){
        return release;
    }
    
    public void Update(){
        if (release==true){
            x=x+xv;
            y=y+yv;
        }
    }
    
}
