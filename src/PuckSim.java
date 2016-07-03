/**
 * Created by Mar on 2/7/16.
 */
import processing.core.PApplet;

public class PuckSim extends PApplet
{
    Puck thePuck;
    public void settings()
    {
        size(800,600);
        thePuck = new Puck(this,100,25);
    }

    public void draw()
    {
        thePuck.setPos(400,400);
        thePuck.draw(200);

    }
}
