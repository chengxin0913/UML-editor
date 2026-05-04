package mode;


import editor.Canvas;
import shape.Object;
import shape.GroupObject;
import shape.AssociationLine;

public class AssociationLineMode extends Mode{
    @Override
    public void releaseAction(Canvas canvas, Object pressedComponent, Object releasedComponent, int mousePressX, int mousePressY, int mouseReleaseX, int mouseReleaseY){
        if(pressedComponent == null || releasedComponent == null || pressedComponent instanceof GroupObject || releasedComponent instanceof GroupObject){// need more condition
            return;
        }
        if(pressedComponent == releasedComponent){
            return;
        }
        else{
            
            canvas.lineComponents.add(new AssociationLine(canvas, mousePressX, mousePressY, mouseReleaseX, mouseReleaseY, pressedComponent, releasedComponent));
            
        }
    }
}
