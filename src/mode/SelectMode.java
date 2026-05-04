package mode;

import editor.Canvas;
import editor.EditorFrame;
import shape.Object;

public class SelectMode extends Mode{
    @Override
    public void clickAction(Canvas canvas, Object currentClickedOnComponent, int x, int y){
        canvas.hideAllPorts();
        if(currentClickedOnComponent == null){
            return;
        }
        currentClickedOnComponent.select(canvas);
    }

    @Override
    public void releaseAction(Canvas canvas, Object pressedComponent, Object releasedComponent,
    int mousePressX, int mousePressY, int mouseReleaseX, int mouseReleaseY){
        if(pressedComponent == null){ // press on null space
            canvas.hideAllPorts();

            //adjsut x&y coor
            if (mousePressX > mouseReleaseX) {
                int tmp = mouseReleaseX;
                mouseReleaseX = mousePressX;
                mousePressX = tmp;
            }
            if (mousePressY > mouseReleaseY) {
                int tmp = mouseReleaseY;
                mouseReleaseY = mousePressY;
                mousePressY = tmp;
            }

            for(int i = 0 ; i < canvas.objectComponents.size() ; i++){
                if(mousePressX <= canvas.objectComponents.get(i).x_min
                        && canvas.objectComponents.get(i).x_max <= mouseReleaseX
                        && mousePressY <= canvas.objectComponents.get(i).y_min
                        && canvas.objectComponents.get(i).y_max <= mouseReleaseY){
                    canvas.objectComponents.get(i).ShowPorts(canvas);
                    canvas.selectedtoGroupComponents.add(canvas.objectComponents.get(i));
                    EditorFrame.setEditMenuGroup(true);
                }
            }
            if(canvas.selectedtoGroupComponents.size() == 1){
                EditorFrame.setEditMenuGroup(false);
            }

        }
        else{
            if(pressedComponent == releasedComponent && mousePressX == mouseReleaseX && mousePressY == mouseReleaseY){//click action
                // something
                EditorFrame.setEditMenuUnGroup(false);
                clickAction(canvas, pressedComponent, mousePressX, mousePressY);
                canvas.selectedComponent = pressedComponent;
            }
            else{
                int x_move = mouseReleaseX - mousePressX;
                int y_move = mouseReleaseY - mousePressY;

                pressedComponent.move(canvas, x_move, y_move);
                pressedComponent.paintMyComponents(canvas);
                canvas.switchTopComponentToArraylistHead(pressedComponent);
                //need to move name

                for(int i = 0 ; i < canvas.lineComponents.size() ; i++){
                    canvas.lineComponents.get(i).paintMyComponents(canvas);
                }
            }
        }
    }
}
