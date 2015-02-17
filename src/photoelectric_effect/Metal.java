package photoelectric_effect;


public class Metal {
    
    float phiMeV;
    double phiJoules;
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
                    phiMeV  = 4.26f; // break used to avoid going through the rest of the switch statement if a match is found
                    phiJoules = 6.816*(10^(-19));
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
                case "Cesium(Cs)":
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
