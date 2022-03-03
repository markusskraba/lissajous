import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Animation extends JPanel implements Globals, ActionListener, Components
{
    
    //die animation hot phi, werte fx, fy, an timer und des cardlayout und action listener?
    private int phi;
    private int fx,fy;
    private Timer timer;
    private CardLayout cardLayout;
    
    
    
    public Animation()
    {
        //i mach des layout
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        
        //für jeden phi wert, füg i a neue figur mit dem phi wert als karte quasi hinzu
        //phi max errechnet sich us den default FMIN FMAX werten
        for (int phi=0;phi<=MAX_PHI;phi++){
            add(new Figure(phi));
            
            
        }
        
        //i setz die variablen von der animation uf des default, also init also wenn ma es startet, sprich die slider inits
        setF(FX_DEFAULT,FY_DEFAULT);
        
        //i mach an neuen timer, mit und setz den 100-80+0 = 20, sprich alle 20 ms und action listener
        timer = new Timer(SPEED_MAX-SPEED_DEFAULT+SPEED_MIN,this);

        
    }
    
    //ok do übergib i eam den Speed value als delay? +2
    public void start(int delay){
        
        //i setz des delay, und denn mach i timer start, und es macht denn alle delay sekunden actionperformed? und es loft so lang wie
        //konstruktor value i guess
        timer.setDelay(delay);
        timer.start();
        
        
    }
    
    //do säg i dem timer er soll aufhören
    public void stop(){
        timer.stop();
        
    }
    
    //setter für alle Fs
    public void setF(int fx, int fy){
        this.fx = fx;
        Figure.setfx(fx);
        this.fy =fy;
        Figure.setfy(fy);
        
        
        
    }
    
    //des wird ausgegührt noch der timer zeit also alle speeslider value ms
    @Override public void actionPerformed (ActionEvent e) {
        //neue card
        cardLayout.next(this);
        //noch der neuen angezeigten karte mach i wieder setF für alles --> aber es isch doch der gliche value?
        setF(fx,fy);
        
    }
    
    
    //setter für die Klassen Fs
    public void setFx(int set){
        fx = set;
    }
    public void setFy(int set){
        fy = set;
    }
    


}
