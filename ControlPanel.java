import javax.swing.*;



public class ControlPanel extends JPanel implements Globals, Components
{

    //des controlpanel isch des pannel oben in dem frame und besteht aus zwei normalen slidern und einem speed slider
    FSlider fxSlider;
    FSlider fySlider;
    SpeedSlider spSlider;

    
    public ControlPanel()
    {
 
        //initialisierung von den slidern
        fxSlider = new FSlider("fx: ",FX_DEFAULT);
        fySlider = new FSlider("fy: ",FY_DEFAULT);
        spSlider = new SpeedSlider("Speed: ",SPEED_DEFAULT);
        
        
        //hinzufügen von den listener interfaces + methode was passiert werden soll wenn sich was verändert
        fxSlider.addChangeListener(changeEvent->{
            //indemfall das in der animation die neuen werte hineingeschrieben werden
            animation.setFx(fxSlider.getValue());
        });
        
        fySlider.addChangeListener(changeEvent->{
            animation.setFy(fySlider.getValue());
        });
  
        //elemente zum panel hinzufügen
        add(fxSlider);
        add(fySlider);
        add(spSlider);
        

    }
    


}
