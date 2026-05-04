package shape;

import java.util.ArrayList;

import editor.Canvas;
import editor.EditorFrame;

public class GroupObject extends Object{
    private ArrayList<Object> grouplist;
    public GroupObject(ArrayList<Object> objs_of_group){
        grouplist = (ArrayList<Object>) objs_of_group.clone();
    }

    @Override
    public void ShowPorts(Canvas canvas){
        // do nothing maybe need to do something change
    }

    @Override
    public void select(Canvas canvas){
        EditorFrame.setEditMenuUnGroup(true);
        for(int i = 0 ; i < grouplist.size() ; i++){
            grouplist.get(i).ShowPorts(canvas);
            // need something
        }
        canvas.switchTopComponentToArraylistHead(this);
    }

    @Override
    public void move(Canvas canvas, int x_move, int y_move){
        for(int i = 0 ; i < grouplist.size() ; i++){
            grouplist.get(i).move(canvas, x_move, y_move);
        }
    }

    @Override
    public void hidePorts(Canvas canvas){
        for(int i = 0 ; i < grouplist.size() ; i++){
            grouplist.get(i).hidePorts(canvas);
        }
    }

    @Override
    public boolean checkIfOnComponent(int x, int y) {
        for (int i = 0; i < grouplist.size(); i++) {
            if (grouplist.get(i).checkIfOnComponent(x, y))
                return true;
        }
        return false;
    }

    @Override
    public void paintMyComponents(Canvas canvas) {
        for (int i = 0; i < grouplist.size(); i++)
            grouplist.get(i).paintMyComponents(canvas);
    }
}
