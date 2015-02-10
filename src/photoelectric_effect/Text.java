
package photoelectric_effect;

import java.awt.*;
import javax.swing.*;

public class Text extends JPanel{
    
    //attributes
    int PanRed=82;
    int PanGreen=82;
    int PanBlue=82;
    
    public Text(){
        
    }
    
    //get rid of paint method
    @Override
    public void paint (Graphics g){
        super.paint(g);
        Electron electron = new Electron();
        
        Color Panel = new Color(PanRed,PanGreen,PanBlue);
        
        //panel
        g.setColor(Panel);
        g.fillRect(600,-1,900,600);
        
        //text
        //text
        g.setColor(Color.WHITE);
        g.drawString("xPosition: " ,602,10);
        g.drawString(electron.xPos(), 655, 10);
        g.drawString("yPosition: ", 602, 25);
        g.drawString(electron.yPos(), 655, 25);
    }
    
}
