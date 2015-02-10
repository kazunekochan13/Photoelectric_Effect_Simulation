/*
 *
 *
 */

package photoelectric_effect;

public class Electron{
    
    //attributes
    int x=50;
    int y=50;
    int xv=2;//(int)Math.floor(Math.random()*5)+1;
    int yv=2;//(int)Math.floor(Math.random()*5)+1;
    int minx=0;
    int miny=0;
    int maxx=600;
    int maxy=600;
    
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
