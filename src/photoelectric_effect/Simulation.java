//http://www.colorschemer.com/online.html

package photoelectric_effect;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Simulation extends JPanel{
    
    //attributes
    int ERed=46;
    int EGreen=0;
    int EBlue=184;
    
    int PanRed=82;
    int PanGreen=82;
    int PanBlue=82;
    
    int PhoRed=199;
    int PhoBlue=0;
    int PhoGreen=99;
    
    int MetRed=160;
    int MetBlue=160;
    int MetGreen=160;
    static Boolean pause=false;
    
    ArrayList<Electron> electron = new ArrayList<Electron>();
    ArrayList<Photon> photon = new ArrayList<Photon>();
    int count=0;
    
    public Simulation(){
        
    }
    
    //painting stuff
    @Override
    public void paint (Graphics g){
        Graphics2D paint = (Graphics2D) g;
        super.paint(g);
        paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color Electron = new Color(ERed, EGreen, EBlue);
        Color Panel = new Color(PanRed,PanGreen,PanBlue);
        Color Photon = new Color(PhoRed,PhoBlue,PhoGreen);
        Color Metal = new Color(MetRed, MetBlue, MetGreen);
        
        //panel & metal surface/name
        paint.setColor(Panel);
        paint.fillRect(680,40,900,600);
        paint.drawLine(0, 320, 680, 320);
        paint.drawLine(0,40,900, 40);
        paint.setColor(Metal);
        paint.fillRect(0, 321, 680, 280);
        
        //position text
        int b=53;//yPos of text
        for (int i=0; i < photon.size();i++){
            paint.setColor(Color.WHITE);
            if (i==0){
                paint.drawString("xPosition: " + photon.get(i).readX(),683,b);
            }
            else{
                b=b+19;
                paint.drawString("xPosition: " + photon.get(i).readX(),683,b);
            }
            b=b+19;
            paint.drawString("yPosition: " + photon.get(i).readY(), 683, b);
        }
        
        
        //drawing photon
        g.setColor(Photon);
        for (int i=0; i< photon.size();i++){
            if (photon.get(i).getStatus()==false){
                g.drawOval(photon.get(i).getxPos(),photon.get(i).getyPos(),3,3);
                g.drawString("hf:",photon.get(i).getxPos()+3,photon.get(i).getyPos());
            }
            
        }
        
        
        //Drawing Electron
        g.setColor(Electron);
        for (int i=0; i < electron.size();i++){
            g.drawOval(electron.get(i).getxPos(),electron.get(i).getyPos(),20,20);
            g.drawString("e-",electron.get(i).getxPos()+6,electron.get(i).getyPos()+14);
        }
        
    }
   
    public void update(){
        /*for (int j=0; j<electron.size();j++){
            if (electron.get(j).returnStatus()==false){
                for (int i=0; i<photon.size();i++){
                    electron.get(j).Absorb(photon.get(i).getX(),photon.get(i).getY()); 
                }
            }
        electron.get(j).Update();
        }
        for (int i=0; i<photon.size();i++){
            photon.get(i).Move();
        }*/
        
        int radii;
        int distanceA;
        int distanceB;
        distanceA = ((electron.get(0).getxPos()+10)-(photon.get(0).getxPos()+3))*((electron.get(0).getxPos()+10)-(photon.get(0).getxPos()+3));
        distanceB = (((electron.get(0).getyPos()+10)-(photon.get(0).getyPos()+3)))*(((electron.get(0).getyPos()+10)-(photon.get(0).getyPos()+1)));
        radii = (int) Math.sqrt(((distanceA)+(distanceB)));
        System.out.println(radii);
        if (radii<=11){
            electron.get(0).changeStatus();
            photon.get(0).changeStatus();
        }
        photon.get(0).Move();
        electron.get(0).Update();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Simulation game = new Simulation();
        
        JFrame frame = new JFrame("Photoelectric Effect Simulator");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //change to dispose later\
        
        JPanel p = new JPanel(new GridBagLayout());
        JButton Play = new JButton("Play/Pause");
        JButton Pause = new JButton("Pause");
        JButton AddIntensity = new JButton("Add Intensity");
        JButton DecIntensity = new JButton("Decrease Intensity");
        GridBagConstraints c = new GridBagConstraints();
        int CountIntensity=1;
        
        //action listeners for buttons
        Play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pause=!pause;
            }
        });
        Pause.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        AddIntensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                game.photon.add(new Photon());
                
            }
        });
        DecIntensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        //layout for buttons
        c.insets = new Insets(3,3,3,3);
        c.gridx=0;
        c.gridy=0;
        p.add(Play,c);
        c.gridx=1;
        c.gridy=0;
        p.add(Pause,c);
        c.gridx=2;
        c.gridy=0;
        p.add(AddIntensity,c);
        c.gridx=3;
        c.gridy=0;
        p.add(DecIntensity,c);
        game.add(p);
        frame.add(game);
        
        /*for (int i=0;i<7;i++){
            int electronX;
            int electronY;
            switch (i){
                case 1:
                    electronX=100;
                    electronY=370;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 2:
                    electronX=150;
                    electronY=500;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 3:    
                    electronX=270;
                    electronY=345;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 4:
                    electronX=519;
                    electronY=372;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 5:
                    electronX=484;
                    electronY=490;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 6:
                    electronX=278;
                    electronY=402;
                    game.electron.add(new Electron(electronX, electronY));break;
            }
            
        }
        for (int i=0; i<5;i++){
            int photonX;
            int photonY;
            switch (i){
                case 0:
                    photonX=30;
                    photonY=50;
                    game.photon.add(new Photon(photonX,photonY)); break;
                case 1:
                    photonX=246;
                    photonY=252;
                    game.photon.add(new Photon(photonX,photonY)); break;
                case 2:
                    photonX=134;
                    photonY=70;
                    game.photon.add(new Photon(photonX,photonY)); break;
                case 3:
                    photonX=40;
                    photonY=164;
                    game.photon.add(new Photon(photonX,photonY)); break;
                case 4:
                    photonX=281;
                    photonY=134;
                    game.photon.add(new Photon(photonX,photonY)); break;
            }
        }*/
        game.photon.add(new Photon(30,50));
        game.electron.add(new Electron(132, 356));
        while(true) { //game loop
                while(pause!=true){
                    game.update();
                    game.repaint();
                    Thread.sleep(25);
                }
        }
    }
}
