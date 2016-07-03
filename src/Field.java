/**
 * Created by Mar on 2/7/16.
 */
import processing.core.*;

public class Field extends PApplet
{
    PApplet parent;

    Field(PApplet _parent,int fieldCenterX, int fieldCenterY, int cameraScale)
    {
        //Escala de transformación. Lo suyo es que sea de la cámara.
        this.m2px = cameraScale;

        this.parent = _parent;
        //Se utilizarán las medidas internacionales (no las Americanas).
        //61 m x 30 m, con radios exteriores de 8,5 m.
        this.fieldWm = (float) 61;
        this.fieldWpx = this.fieldWm * m2px;

        this.fieldHm = (float) 30;
        this.fieldHpx = (int) this.fieldHm * m2px;

        this.fieldExtRm = (float) 8.5;
        this.fieldExtRpx = (int) (this.fieldExtRm * m2px);

        this.center = new PVector(fieldCenterX,fieldCenterY);

        this.thePuck = new Puck(this,156, (float) 36.2);
    }

    PVector getPuckPosition()
    {
        PVector pPosition = new PVector(0,0);
        return pPosition;
    }

    void draw(float scale)
    {

        //Dibujamos el campo
        parent.fill(255);
        parent.stroke(255);
        parent.rectMode(CENTER);
        parent.rect(this.center.x,this.center.y,
                   (this.fieldWpx-2*this.fieldExtRpx)*scale,
                   (this.fieldHpx)*scale);

        parent.ellipseMode(CENTER);
        parent.ellipse((this.center.x-(this.fieldWpx/2)+this.fieldExtRpx)*scale,
                       (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                       this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        parent.ellipse((this.center.x-(this.fieldWpx/2)+this.fieldExtRpx)*scale,
                       (this.center.y+(this.fieldHpx/2)-this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        parent.ellipse((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                       (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        parent.ellipse((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                       (this.center.y+(this.fieldHpx/2)-this.fieldExtRpx)*scale,
                        this.fieldExtRpx*scale*2,this.fieldExtRpx*scale*2);

        parent.rectMode(CORNER);
        parent.rect((this.center.x+(this.fieldWpx/2)-this.fieldExtRpx)*scale,
                        (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                        (this.fieldExtRpx)*scale,
                        (this.fieldHpx-2*this.fieldExtRpx)*scale);

        parent.rect((this.center.x-(this.fieldWpx/2))*scale,
                (this.center.y-(this.fieldHpx/2)+this.fieldExtRpx)*scale,
                (this.fieldExtRpx)*scale,
                (this.fieldHpx-2*this.fieldExtRpx)*scale);

        //Dibujamos la pastilla

        PVector puckPos = new PVector(this.thePuck.getPos().x,this.thePuck.getPos().y);
        float radious =  (this.thePuck.getRadious()/1000)*this.m2px*scale;
        parent.stroke(0);
        parent.fill(0);
        parent.ellipseMode(CENTER);

        if (radious < 0.5)
        {
            //System.out.println("Puck's px raidous < 1!");
            //System.out.println(radious);
            radious = 1;
        }
        //System.out.println(radious);
        parent.ellipse(400,400,radious*2,radious*2);
    }


    //Ancho y alto del campo, en metros
    private float fieldWm;
    private float fieldHm;
    //Radio exterior
    private float fieldExtRm;

    //Medidas equivalentes, en píxeles
    private float fieldWpx;
    private float fieldHpx;
    //Radio exterior
    private int fieldExtRpx;

    private float m2px;

    private PVector center;

    private Puck thePuck;
}
