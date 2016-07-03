/**
 * Created by Mar on 2/7/16.
 */
import processing.core.PApplet;

public class PuckSim extends PApplet
{
    Field theField;
    public void settings()
    {
        size(1500,800);
        theField = new Field(this,width/2,height/2,24);
    }

    public void draw()
    {
        background(0,38,153);
        theField.draw(1);
        //save("imgs/hockeyField1.tif");
        exit();

    }
}
