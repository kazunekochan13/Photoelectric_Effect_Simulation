//http://www.colorschemer.com/online.html
//test commit

package photoelectric_effect;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Simulation extends JPanel{
    
    //attributes
    int x=300;
    int y=300;
    int xv=1;
    int yv=-1;
    int minx=0;
    int miny=0;
    int maxx=585;
    int maxy=550;
    
    int px=0;
    int py=0;
    int pxv=1;
    int pyv=1;
    
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
    private JButton Play;
    
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
        
        
        //test position
        paint.setColor(Electron);
        paint.drawOval(100, 370, 20,20);
        paint.drawString("e-", 106, 384);
        paint.drawOval(150, 500, 20,20);
        paint.drawString("e-", 156, 514);
        paint.drawOval(300, 330, 20,20);
        paint.drawString("e-", 306, 344);
        
        //drawing photon
        g.setColor(Photon);
        for (int i=0; i< photon.size();i++){
            g.drawOval(photon.get(i).getxPos(),photon.get(i).getyPos(),3,3);
            g.drawString("hf:",photon.get(i).getxPos()+3,photon.get(i).getyPos());
        }
        
        
        //Drawing Electron
        g.setColor(Electron);
        for (int i=0; i < electron.size();i++){
            g.drawOval(electron.get(i).getxPos(),electron.get(i).getyPos(),20,20);
            g.drawString("e-",electron.get(i).getxPos()+6,electron.get(i).getyPos()+14);
        }
        
    }
        
    
    
    public void Move(){
        if (px<300){
            px=px+pxv;
            py=py+pyv;    
        }
        else{
            x=x+xv;
            y=y+yv;
        }
    }
   
    public void move1(){
        for (int i=0; i < electron.size();i++){
            electron.get(i).Boundaries();
            electron.get(i).Collide();
        }
        for (int i=0; i<photon.size();i++){
            photon.get(i).Boundaries();
            photon.get(i).Collide();
        }
        
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
        game.photon.add(new Photon());
        game.electron.add(new Electron());
        
        while(true) { //game loop
                while(pause!=true){
                    game.move1();
                    game.repaint();
                    Thread.sleep(20);
                }
        }
    }
}
