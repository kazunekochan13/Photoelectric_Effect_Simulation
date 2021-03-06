/*
 *
 *
 */

package photoelectric_effect;

public class Photon{
    
    private int x=50;
    private int y=50;
    private int xv=1;
    private int yv=3;
    private int minx=0;
    private int miny=40;
    private int maxx=678;
    private int maxy=557;
    
    private double joules=1.99E-22;
    private double MeV=1.24E-5;
    private Boolean absorb=false;
    
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
        switch (emRegion){ //all photon energies are average of the range
            case "Radiowaves":
                joules=1.99E-24;
                MeV=1.24E-5; break;
            case "Microwaves":
                joules=1.00E-22;
                MeV=6.28E-1; break;
            case "Infrared":
                joules=1.42E-19;
                MeV=8.89E-1; break;
            case "Red":
                joules=2.93E-19;
                MeV=1.83;
                MeV = Double.parseDouble(String.format("%.3g%n", MeV)); break;
            case "Blue":
                joules=4.22E-19;
                MeV=2.64;
                MeV = Double.parseDouble(String.format("%.3g%n", MeV)); break;
            case "UltraViolet":
                joules=1.02E-17;
                MeV=6.37E1;
                MeV = Double.parseDouble(String.format("%.3g%n", MeV)); break;
            case "X-Rays":
                joules=9.95E-15;
                MeV=6.22E4;
                MeV = Double.parseDouble(String.format("%.3g%n", MeV)); break;
            case "Gamma":
                joules=1.99E-14;
                MeV=1.24E5;
                MeV = Double.parseDouble(String.format("%.3g%n", MeV)); break;
        }
    }
    
    public double getEnergy(String units){
        if ("J".equals(units)){
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
    
    public void Move(){
        if (absorb==false){
            x=x+xv;
            y=y+yv;
        }
    }
        
    
}
