/**
 * Created by Mar on 5/7/16.
 */

import processing.core.*;

public class Camera extends PApplet
{
        PApplet parent;

        Camera(PApplet _parent, float focal, PVector resolution, PVector position, PVector rotations)
        {
            this.parent = _parent;
        }
}
