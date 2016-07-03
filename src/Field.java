/**
 * Created by Mar on 2/7/16.
 */
import processing.core.*;

public class Field
{
    public Field(int w,int h)
    {
        //Ancho y alto del campo en metros.
        this.fieldWm = w;
        this.fieldHm = h;
    };

    public PVector getPuckPosition()
    {
        PVector pPosition = new PVector(0,0);
        return pPosition;
    };


    //Ancho y alto del campo, en metros
    private float fieldWm;
    private float fieldHm;

    private Puck thePuck;
}
