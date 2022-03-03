import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;

public class Figure extends JPanel implements Globals
{
    
    //ok für die fifure mathe berechnung bruch i die X Y sachen umgerechnet --> statisch damit se für alle objekte glich sind
    private static int fx = FX_DEFAULT*180;
    private static int fy = FY_DEFAULT*180;
    
    private int phi;

    //phi übergib i immer vo da animation
    public Figure(int phi)
    {
        //super true, woas nüm
        super(true);
        
        this.phi=phi;
        //ok
        setBackground(TRANSPARENT);

    }
    
    @Override public void paintComponent(Graphics g){
        //i änder die paintcomponent vom panel, also i übergib eam des graphics ding
        super.paintComponent(g);
        //i wandel des graphics ding um damit i es ändern kann (glob i )
        Graphics2D g2d=(Graphics2D) g;
        
        //des isch für des koordinatensystem
        g2d.setColor(COORDINATE);
        g2d.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
        g2d.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
        g2d.setColor(Color.BLACK);
        
        //tmax berechnen
        int tmax = fx*fy/90;
        
        //miite berechnen ok
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        
        //die punkte ausrechnen
        int xStart = transform(u(0,fx),centerX);
        int yStart = transform (u(0+phi,fy), centerY);
        
        int xEnd, yEnd;
        
        //i zeichne jetzt eine linie für linie zwischen den zwei punkten der funnktion bis des ganze ding gezeichnet isch
        for(int t = 1;t<=tmax;t++){
        //do rechne i des ende us
            xEnd = transform(u(t,fx),centerX);
            yEnd = transform(u(t+phi,fy),centerY);
            
            //i zeichne einen teil
            g2d.drawLine(xStart,yStart,xEnd,yEnd);
            
            //i mach des mit dem nächsten punkt
            xStart = xEnd;
            yStart = yEnd;
        }
        
        
        
        
    }
    
    //i find des ehrlich gseht kle an joke, was erwartet der bitte, des isch viel zu komplex
    //u funktion
    private double u(int t,int f) {
        return Math.sin((Math.PI*t)/(f));
    }
    
    //transform, damit i die werte uf des koordinatensystem von dem jpanel umrechnet
    private int transform( double coordinate, int center){
         
        return center+(int) Math.floor(center*coordinate);
    }
    
    //okay seter für des umrechnen
    static void setfx(int value) { fx = value*180;}
    static void setfy(int value) { fy = value * 180;}
    
    //okay seter für phi
    void setPhi(int value) {phi = value;}

}
