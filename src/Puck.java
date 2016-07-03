/**
 * Created by Mar on 2/7/16.
 */
import processing.core.*;

public class Puck
{
    PApplet parent;

    public Puck(PApplet _parent, float weigth, float radious)
    {
        this.parent = _parent;
        this.weight = weigth;
        this.radious = radious;
        this.position = new PVector(0,0);
    }
    public void draw(float fieldScale)
    {
        parent.stroke(127);
        parent.fill(127);
        parent.ellipse(100,100,100,100);

    }
    public void setPos(float x, float y)
    {
        this.position.x = x;
        this.position.y = y;
    }
    public void setSpeed()
    {

    }
    public void setAcc()
    {

    }
    public PVector getPos()
    {
        return this.position;
    }
    public PVector getSpeed()
    {
        return this.speed;
    }

    public PVector getAcc()
    {
        return this.acc;
    }

    //Posicion de la pastilla, en m, con referencia al 0,0 del campo.
    private PVector position;
    //Velocidad y aceleración, en m/s y m/s^2, respectivamente
    private PVector speed;
    private PVector acc;
    //Peso, en gramos, de la pastilla
    private float weight;
    //Radio de la pastilla, en mm
    private float radious;
}
