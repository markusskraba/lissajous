import javax.swing.JSlider;
import javax.swing.*;
import javax.swing.event.*;


public class Slider extends JPanel implements Globals
{

    //an slider als panel
    //hot a label für den wert und den text
    protected JLabel valueLabel;
    protected JLabel textLabel;
    protected JSlider slider;
    //sowie die range
    int min, max;
    
    
    
    //wenn i an slider mach, denn brucht er an text, i muss eam die range säga, des mit den ticks und den initialwert
    public Slider(String text,int min, int max, int ticks, int init)
    {
        //konstruktor
        this.min = min;
        this.max = max;
        
        //i säg den labels was se für werte hon
        valueLabel = new JLabel(""+init);
        textLabel = new JLabel(text);
        //und füg se dem panel hinzu
        add(textLabel);
        add(valueLabel);
        
        
        //denn mach i an neuen slider mit den werten im konstruktor
        slider = new JSlider(min,max,init);
        //und setz die ticks
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(ticks);
        
        //denn füg i eam an listener hinzu und säg beim verändern soll er den wert text ändern (warum mach i des jetzt do 2x und ned glei im listener davor?'
        //ah weil im listener davor muss i jo wissen welches i änder ob X oder Y, do isch des bei jedem slider so. check! 
        //i woas aber ned warum i des eig ned mit implements mach?? sondern mit add
        slider.addChangeListener(changeEvent ->{
            valueLabel.setText(""+getValue());
        });
        
        //und zum schluss füg i ean hinzu
        add(slider);

    }
    
    //an getter
    public int getValue(){
        return slider.getValue();
    }
    
    // warum do etz nommol?
    // AAHHHHHH JETZT VERSTEH I, i definier do quasi diese methode was passiert wenn i se aufruf und denn wenn i earn hinzufüg mach i des mit überschreiben
    public void addChangeListener(ChangeListener listener){
        slider.addChangeListener(listener);
    }
    


}
