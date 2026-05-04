package mode;

import editor.Canvas;
import shape.UseCaseObj;
import shape.Object;

public class UseCaseMode extends Mode{

    @Override
    public void clickAction(Canvas canvas, Object currentClickedOnComponent, int x, int y){
        if(currentClickedOnComponent != null){
            return;
        }
        canvas.objectComponents.add(new UseCaseObj(canvas, x, y));
    }

    @Override
    public void releaseAction(Canvas canvas, Object pressedComponent, Object releasedComponent, int mousePressX, int mousePressY,
            int mouseReleaseX, int mouseReleaseY) {
        clickAction(canvas, pressedComponent, mouseReleaseX, mouseReleaseY);
    }
}
