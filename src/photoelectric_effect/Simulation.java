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
    
    int PanRed=7;
    int PanGreen=54;
    int PanBlue=66;
    
    int PhoRed=199;
    int PhoBlue=0;
    int PhoGreen=99;
    
    int MetRed=160;
    int MetBlue=160;
    int MetGreen=160;
    
    int txtRed=238;
    int txtGreen=232;
    int txtBlue=213;
    
    ArrayList<Electron> electron = new ArrayList<Electron>();
    ArrayList<Photon> photon = new ArrayList<Photon>();
    int count=0;
    
    int NoOfIntensity=1;
    int MetalNo=1;
    double workFunction=4.26; //initial MeV
    double photonEnergy=1.24E-5; //intial MeV
    
    static Boolean pause=false;
    static Boolean clickRestart=false;
    static String[] EM={"Radiowaves", "Microwaves","Infrared", "Red","Blue", "UltraViolet", "X-Rays", "Gamma"};
    static JComboBox JCBWaves = new JComboBox(EM);
    static String[] WF={"Silver(Ag)", "Aluminium(Al)", "Gold(Au)", "Caesium(Cs)", "Copper(Cu)", "Lithium(Li)", "Lead(Pb)", "Tin(Sn)","Iridium(Ir)", "Yttrium(Y)","Zinc(Zn)","Nickel(Ni)","Cobalt(Co)"};
    static JComboBox JCBMetal = new JComboBox(WF);
    static String[] UN={"MeV", "Joules"};
    static JComboBox JCBUnits = new JComboBox(UN);
    static String currentWave="Radiowaves";
    static String currentMetal="Silver(Ag)";
    static String Units="MeV";
    
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
        Color Text = new Color(txtRed,txtGreen,txtBlue);
        
        //panel & metal surface/name
        paint.setColor(Panel);
        paint.fillRect(680,40,900,600); //right panel
        paint.drawLine(0, 320, 680, 320); //metal outline
        paint.drawLine(0,40,900, 40); //top panel
        paint.setColor(Metal); 
        paint.fillRect(0, 321, 680, 280); //metal fill
        
        //drawing photon
        g.setColor(Photon);
        for (int i=0; i< photon.size();i++){
            if (photon.get(i).getStatus()==false){
                g.drawOval(photon.get(i).getxPos(),photon.get(i).getyPos(),3,3);
                g.drawString(" "+i ,photon.get(i).getxPos()+3,photon.get(i).getyPos());
            }
        }
        
        //Drawing Electron
        
        for (int i=0; i < electron.size();i++){
            if (electron.get(i).getyPos()<=40){
            }
            else if(electron.get(i).getxPos()+20>=678){
            }
            else{
                g.setColor(Electron);
                g.drawOval(electron.get(i).getxPos(),electron.get(i).getyPos(),20,20);
                g.drawString("e-",electron.get(i).getxPos()+6,electron.get(i).getyPos()+14);
                if (electron.get(i).getStatus()==true){
                    g.drawString(i + ") " + Double.toString(electron.get(i).getEnergy()),electron.get(i).getxPos()+6,electron.get(i).getyPos());
                }
                else{
                    g.drawString(i + ")", electron.get(i).getxPos()+6,electron.get(i).getyPos());
                }
            }
        }
        
        //side text
        paint.setColor(Text);
        paint.drawString("Metal: " + currentMetal,685,53);
        paint.drawString("Work Function: " + workFunction + " " + Units, 685,72);
        paint.drawString("EM wave: " + currentWave, 685, 91);
        paint.drawString("Intensity: " + NoOfIntensity, 685, 110);
        if (clickRestart==true){
            paint.setColor(Color.RED);
            paint.drawString("Please click restart to see changes",685,123);
        }
        /*int b=156;//yPos of text 53
        for (int i=0; i < photon.size();i++){
            paint.setColor(Color.WHITE);
            if (i==0){
                paint.drawString("Photon XPos: " + photon.get(i).readX(),685,b);
            }
            else{
                b=b+19;
                paint.drawString("PhotonXPos: " + photon.get(i).readX(),685,b);
            }
            b=b+19;
            paint.drawString("Photon XPos: " + photon.get(i).readY(), 685, b);
        }
        */
        int b=136;
        paint.setColor(Text);
        paint.drawString("Photon Energy: " + photon.get(0).getEnergy(Units) + " " + Units, 685, b);
        b=b+20;
        for (int i=0;i < electron.size();i++){
            paint.setColor(Text);
            if (i==0){
                paint.drawString("Electron 1: " + electron.get(i).getEnergy() + " " + Units,685,b);
            }
            else{
                b=b+20;
                paint.drawString("Electron " + (i+1) + ": " + electron.get(i).getEnergy() + " " + Units,685,b);
            }
        }
    }
   
    public void update(){
        for (int j=0;j<photon.size();j++){
            for (int i=0;i<electron.size();i++){
                int radii;
                int distanceA;
                int distanceB;
                distanceA = ((electron.get(i).getxPos()+10)-(photon.get(j).getxPos()+3))*((electron.get(i).getxPos()+10)-(photon.get(j).getxPos()+3));
                distanceB = (((electron.get(i).getyPos()+10)-(photon.get(j).getyPos()+3)))*(((electron.get(i).getyPos()+10)-(photon.get(j).getyPos()+1)));
                radii = (int) Math.sqrt(((distanceA)+(distanceB)));
                if (radii<=11 && electron.get(i).getStatus()==false){
                    electron.get(i).calcEnergy(photon.get(j).getEnergy(Units), workFunction, Units);
                    photon.get(j).changeStatus();
                }
            }
            photon.get(j).Move();
        }
        for (int i=0;i<electron.size();i++){
            if (electron.get(i).getStatus()==true){
                    electron.get(i).Update();
                }
        }
    }
        
    
    public static void main(String[] args) throws InterruptedException {
        Simulation game = new Simulation();
        Metal mt = new Metal();
        
        JFrame frame = new JFrame("Photoelectric Effect Simulator");
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //change to dispose later
        
        JPanel p = new JPanel(new GridBagLayout());
        JButton Play = new JButton("Play/Pause");
        JButton Restart = new JButton("Restart");
        JButton AddIntensity = new JButton("Add Intensity");
        JButton DecIntensity = new JButton("Decrease Intensity");
        JButton Questions = new JButton("Questions");
        GridBagConstraints c = new GridBagConstraints();
        int CountIntensity=1;
        
        //action listeners for buttons
        Play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pause=!pause;
            }
        });
        Restart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.electron.clear();
                game.photon.clear();
                //game.photon.add(new Photon(30,50));
                for (int i=0; i<game.NoOfIntensity;i++){
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
                        case 5:
                            photonX=30;
                            photonY=300;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 6:
                            photonX=465;
                            photonY=192;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 7:
                            photonX=395;
                            photonY=200;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 8:
                            photonX=290;
                            photonY=55;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 9:
                            photonX=222;
                            photonY=122;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 10:
                            photonX=390;
                            photonY=63;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 11:
                            photonX=152;
                            photonY=145;
                            game.photon.add(new Photon(photonX,photonY)); break;
                    }
                    game.photon.get(i).getHf(currentWave, Units);
                }
                for (int i=0;i<13;i++){
                    int electronX;
                    int electronY;
                    switch (i){
                        case 1:
                            electronX=132;
                            electronY=356;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 2:
                            electronX=270;
                            electronY=345;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 3:    
                            electronX=246;
                            electronY=416;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 4:
                            electronX=144;
                            electronY=482;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 5:
                            electronX=398;
                            electronY=500;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 6:
                            electronX=70;
                            electronY=400;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 7:
                            electronX=519;
                            electronY=372;
                            game.electron.add(new Electron(electronX,electronY));break;
                        case 8:
                            electronX=484;
                            electronY=490;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 9:
                            electronX=400;
                            electronY=388;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 10:
                            electronX=337;
                            electronY=467;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 11:
                            electronX=463;
                            electronY=332;
                            game.electron.add(new Electron(electronX, electronY));break;
                        case 12:
                            electronX=278;
                            electronY=523;
                            game.electron.add(new Electron(electronX, electronY));break;
                    } 
                }
                mt.assignWF(currentMetal);
                if (Units=="J"){
                    game.workFunction=mt.getJoules();
                }
                else if (Units=="MeV"){
                    game.workFunction=mt.getMeV();
                }
                
                clickRestart=false;
                pause=false;
            }
        });
        AddIntensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.NoOfIntensity<12){ //change to 10 later
                    game.NoOfIntensity = game.NoOfIntensity +1;
                    
                    int photonX;
                    int photonY;
                    switch (game.NoOfIntensity-1){
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
                        case 5:
                            photonX=30;
                            photonY=300;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 6:
                            photonX=465;
                            photonY=192;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 7:
                            photonX=395;
                            photonY=200;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 8:
                            photonX=290;
                            photonY=55;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 9:
                            photonX=222;
                            photonY=122;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 10:
                            photonX=390;
                            photonY=63;
                            game.photon.add(new Photon(photonX,photonY)); break;
                        case 11:
                            photonX=152;
                            photonY=145;
                            game.photon.add(new Photon(photonX,photonY)); break;
                    }
                    game.photon.get(game.NoOfIntensity-1).getHf(currentWave, Units);
                }
                
                
            }
        });
        DecIntensity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.NoOfIntensity > 1){
                    game.NoOfIntensity = game.NoOfIntensity -1;
                    game.photon.remove(game.photon.size()-1);
                }
                else if (game.NoOfIntensity==1){
                }
            }
        });
        JCBMetal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        currentMetal = (String) combo.getSelectedItem();
                        clickRestart=true;
                        
            }
        });
        JCBWaves.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        currentWave = (String) combo.getSelectedItem();
                        clickRestart=true;
            }
        });
        JCBUnits.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        if ((String) combo.getSelectedItem()=="Joules"){
                            Units="J";
                        }
                        else if ((String) combo.getSelectedItem()=="MeV"){
                            Units="MeV";
                        }
                        clickRestart=true;
            }
        });
        Questions.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //opens the question answering form
            }
        });
        
        game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("x: " + e.getX());
                System.out.println("y: " + e.getY());
               
            }
        });
        
        //layout for buttons
        c.insets = new Insets(3,3,0,3);
        c.gridx=0;
        c.gridy=0;
        p.add(Play,c);
        c.gridx=1;
        c.gridy=0;
        p.add(Restart,c);
        c.gridx=2;
        c.gridy=0;
        p.add(AddIntensity,c);
        c.gridx=3;
        c.gridy=0;
        p.add(DecIntensity,c);
        c.gridx=4;
        c.gridy=0;
        p.add(JCBMetal,c);
        c.gridx=5;
        c.gridy=0;
        p.add(JCBWaves,c);
        c.gridx=6;
        c.gridy=0;
        p.add(JCBUnits,c);
        c.gridx=7;
        c.gridy=0;
        p.add(Questions,c);
        game.add(p);
        frame.add(game);
        
        for (int i=0;i<13;i++){
            int electronX;
            int electronY;
            switch (i){
                case 1:
                    electronX=132;
                    electronY=356;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 2:
                    electronX=270;
                    electronY=345;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 3:    
                    electronX=246;
                    electronY=416;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 4:
                    electronX=144;
                    electronY=482;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 5:
                    electronX=398;
                    electronY=500;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 6:
                    electronX=70;
                    electronY=450;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 7:
                    electronX=519;
                    electronY=372;
                    game.electron.add(new Electron(electronX,electronY)); break;
                case 8:
                    electronX=484;
                    electronY=490;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 9:
                    electronX=400;
                    electronY=388;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 10:
                    electronX=337;
                    electronY=467;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 11:
                    electronX=463;
                    electronY=332;
                    game.electron.add(new Electron(electronX, electronY));break;
                case 12:
                    electronX=278;
                    electronY=523;
                    game.electron.add(new Electron(electronX, electronY));break;
            } 
        }
        
        game.photon.add(new Photon(30,50));
        while(true) { //game loop
                while(pause!=true){
                    game.update();
                    game.repaint();
                    Thread.sleep(25);
                }
        }
    }
}
