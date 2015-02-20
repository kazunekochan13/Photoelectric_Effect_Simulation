package photoelectric_effect;

import java.lang.Math.*;

public class Metal {
    
    double phiMeV;
    double phiJoules;
    int HfMeV;
    int HfJoules;
    int Intensity;
    String nameOfMetal;
    String DisplayJ; //display Joules values
    String DisplayM; //Display MeV values
    String material;
    
    public Metal(){
        
    }
    
    public void assignWF(String metal){
        switch (metal){
                case "Silver(Ag)":
                    phiMeV  = 4.26;
                    phiJoules = 6.82E-19; break;
                case "Aluminium(Al)":
                    phiMeV = 4.28f;
                    phiJoules = 6.85E-19; break;
                case "Gold(Au)":
                    phiMeV = 5.1f;
                    phiJoules = 8.16E-19; break;
                case "Caesium(Cs)":
                    phiMeV = 2.14f;
                    phiJoules = 3.42E-19; break;
                case "Copper(Cu)":
                    phiMeV = 4.65f;
                    phiJoules = 7.44E-19; break;
                case "Lithium(Li)":
                    phiMeV = 2.9f;
                    phiJoules = 4.64E-19; break;
                case "Lead(Pb)":
                    phiMeV = 4.25f;
                    phiJoules = 6.80E-19; break;
                case "Tin(Sn)":
                    phiMeV = 4.42f; 
                    phiJoules = 7.07E-19; break;
            }
    }
    
    public double getMeV(){
        return phiMeV;
    }
    
    public double getJoules(){
        return phiJoules;
    }
    
}
