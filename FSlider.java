import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;




public class FSlider extends Slider implements Globals, Components
{

    public FSlider(String label, int init)
    {
        //super konstruktor für Slider, ok also wenn i an FSLIDER mach denn machts des min max, ticks zeug automatisch 
        // was isch denn bitte der Sinn davon?? 
        super(label,F_MIN,F_MAX,F_TICKS,init);
        //idk warum des do drin isch und ned in slider
        slider.setPaintLabels(true);
        valueLabel.setVisible(false);
        
        

    }

}
