/**
 * Created by Mar on 2/7/16.
 */
import processing.core.*;

public class Field extends PApplet
{
    PApplet parent;

    public Field(PApplet _parent)
    {
        this.parent = _parent;
        //Se utilizarán las medidas internacionales (no las Americanas).
        //61 m x 30 m, con radios exteriores de 8,5 m.
        this.fieldWm = (float) 61;
        this.fieldHm = (float) 30;
        this.fieldExtRm = (float) 8.5;
        this.thePuck = new Puck(this,156, (float) 36.2);
    }

    public PVector getPuckPosition()
    {
        PVector pPosition = new PVector(0,0);
        return pPosition;
    }

    public void draw(float scale)
    {

    }


    //Ancho y alto del campo, en metros
    private float fieldWm;
    private float fieldHm;
    //Radio exterior
    private float fieldExtRm;

    //Medidas equivalentes, en píxeles
    private int fieldWpx;
    private int fieldHpx;
    //Radio exterior
    private int fieldExtRpx;

    private float m2pxScale;

    private Puck thePuck;
}
