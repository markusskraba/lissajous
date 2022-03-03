import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SpeedSlider extends Slider implements Globals, Components
{

    public SpeedSlider(String text, int init)
    {
        
        //same thing with speed
        super(text,SPEED_MIN,SPEED_MAX,SPEED_TICKS,init);

        //blabla
        slider.setMinorTickSpacing(5);
        
        //nommol an change listener mit    
        addChangeListener(changeEvent->{

            //falls der wert (20) > 0 
            //ahh des isch wegen dem reversed BS
            if (getValue()>SPEED_MIN) {
                //animation starten mit dem wert (indem fall 80 + 2) why clamp?
                animation.start(super.getValue()+SPEED_CLAMPING);
            } else{
                //falls der wert 0 isch --> animation stoppen
                animation.stop();
            }
        });
    }
    
    @Override public int getValue(){
        //ok überschreiben für speed slider
        //100 - value + 0
        // 100 - 80 + 0 = 20?
        return max-super.getValue()+min;
    }

}
