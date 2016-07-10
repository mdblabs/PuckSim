/**
 * Created by Mar on 2/7/16.
 */
import processing.core.*;

public class Field extends PApplet
{
    PApplet parent;

    Field(PApplet _parent,int fieldCenterX, int fieldCenterY, int m2px)
    {

        //Escala de transformación de metros a píxeles
        this.m2px = m2px;

        this.parent = _parent;
        //Se utilizarán las medidas internacionales (no las Americanas).
        //61 m x 30 m, con radios exteriores de 8,5 m.
        this.fieldWm = (float) 61;
        this.fieldWpx = (int) this.fieldWm * m2px;

        this.fieldHm = (float) 30;
        this.fieldHpx = (int) this.fieldHm * m2px;

        this.fieldBuffer = createGraphics(this.fieldWpx, this.fieldHpx);

        this.fieldExtRm = (float) 8.5;
        this.fieldExtRpx = (int) (this.fieldExtRm * m2px);

        this.center = new PVector(fieldCenterX,fieldCenterY);

        this.thePuck = new Puck(this,156,(float) 36.2);
    }

    PVector getPuckPosition()
    {
        PVector pPosition = new PVector(0,0);
        return pPosition;
    }

    void draw(float scale)
    {

        //Dibujamos el campo
        this.fieldBuffer.beginDraw();
        this.fieldBuffer.fill(255);
        this.fieldBuffer.stroke(255);
        this.fieldBuffer.rectMode(CENTER);
        this.fieldBuffer.rect(this.center.x,this.center.y,
                   (this.fieldWpx-2*this.fieldExtRpx)*scale,
                   (this.fieldHpx)*scale);

        this.fieldBuffer.ellipseMode(CENTER);
        this.fieldBuffer.ellipse((this.center.x-(this.fieldWpx/2)+this.fieldExtRpx)*scale,
                       (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                       this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        this.fieldBuffer.ellipse((this.center.x-(this.fieldWpx/2)+this.fieldExtRpx)*scale,
                       (this.center.y+(this.fieldHpx/2)-this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        this.fieldBuffer.ellipse((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                       (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        this.fieldBuffer.ellipse((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                       (this.center.y+(this.fieldHpx/2)-this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        this.fieldBuffer.rectMode(CORNER);
        this.fieldBuffer.rect((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                        (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                        (this.fieldExtRpx)*scale,
                        (this.fieldHpx-2*this.fieldExtRpx)*scale);

        this.fieldBuffer.rect((this.center.x-(this.fieldWpx/2))*scale,
                (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                (this.fieldExtRpx)*scale,
                (this.fieldHpx-2*this.fieldExtRpx)*scale);

        //Dibujamos la pastilla

        PVector puckPos = new PVector(this.thePuck.getPos().x,this.thePuck.getPos().y);
        float radious =  (this.thePuck.getRadious()/1000)*this.m2px*scale;
        this.fieldBuffer.stroke(0);
        this.fieldBuffer.fill(0);
        this.fieldBuffer.ellipseMode(CENTER);

        if (radious < 0.5)
        {
            //System.out.println("Puck's px raidous < 1!");
            //System.out.println(radious);
            radious = 1;
        }
        //System.out.println(radious);
        this.fieldBuffer.ellipse(400,400,radious*2,radious*2);
        this.fieldBuffer.endDraw();
    }


    //Buffer, para pintar sin aplicar transformación de cámara
    private PGraphics fieldBuffer;

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

    private float m2px;

    private PVector center;

    private Puck thePuck;
}
