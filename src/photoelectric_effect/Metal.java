package photoelectric_effect;

import java.lang.Math.*;

public class Metal {
    
    float phiMeV;
    float phiJoules;
    int HfMeV;
    int HfJoules;
    int Intensity;
    String nameOfMetal;
    String DisplayJ; //display Joules values
    String DisplayM; //Display MeV values
    String material;
    
    public Metal(String metal){
        switch (metal){
                case "Silver(Ag)":
                    phiMeV  = 4.26f;
                    phiJoules = 500;
                    DisplayM = String.format("%.3g%n", phiMeV); //rounds up number to 3sf
                    
                    break;
                case "Aluminium(Al)":
                    phiMeV = 4.28f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
                case "Gold(Au)":
                    phiMeV = 5.1f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
                case "Caesium(Cs)":
                    phiMeV = 2.14f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
                case "Copper(Cu)":
                    phiMeV = 4.65f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    
                    break;
                case "Lithium(Li)":
                    phiMeV = 2.9f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
                case "Lead(Pb)":
                    phiMeV = 4.25f;
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
                case "Tin(Sn)":
                    phiMeV = 4.42f; 
                    DisplayM = String.format("%.3g%n", phiMeV);
                    
                    break;
            }
    }
    
}
