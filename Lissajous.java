import java.awt.*;
import javax.swing.*;


//jframe --> fenster
public class Lissajous extends JFrame implements Components, Globals
{
    
    //static weil? 
    static Lissajous lj;
    //borderlayout up north west south
    BorderLayout borderLayout = new BorderLayout();
    

    /**
     * Konstruktor für Objekte der Klasse Test
     */
    public Lissajous()
    {
        
        //layout vom fenster
        setLayout(borderLayout);
        //titel oben links vom fenster
        setTitle("Lissajous Figure");
        //was passiert wenn man uf x drückt --> programm schließen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //größe vom fenster
        setSize(800,600);
        //sachen hinzufügen zum fenster --> animation komponente in der mitte
        add(animation,BorderLayout.CENTER);
        //sachen hinzufügen zum fenster --> control komponente oben
        add(controlPanel,BorderLayout.NORTH);
        //anzeigen vom fenster
        setVisible(true);

    }

    public static void main(String args[]){
        //versuchen neues fenster zum machen, falls es ned klappt denn excpetion error
        try{
            lj = new Lissajous();
        } catch(Exception e){
            e.printStackTrace();
            
            throw e;
        }
        
        
    }
    

    
}
