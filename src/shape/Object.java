package shape;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

import editor.Canvas;

public class Object extends Shape{
    protected ArrayList<JLabel> portsArray = new ArrayList<JLabel>();

    public void ShowPorts(Canvas canvas){
        int[] xPortLoc = {((this.x_min + this.x_max) / 2) - 5, this.x_max - 5, ((this.x_min + this.x_max) / 2) - 5, this.x_min - 5};
        int[] yPortLoc = {this.y_min - 5, ((this.y_min + this.y_max) / 2) - 5, this.y_max - 5, ((this.y_min + this.y_max) / 2) - 5};

        for(int i = 0 ; i < 4 ; i++){
            JLabel tmpPort = new JLabel();
            tmpPort.setBackground(Color.black);
            tmpPort.setBounds(xPortLoc[i], yPortLoc[i], 10, 10);
            tmpPort.setOpaque(true);
            portsArray.add(tmpPort);
            canvas.add(tmpPort, 2);
        }

        canvas.repaint();
    }

    public void select(Canvas canvas){

    }

    public void move(Canvas canvas, int x_move, int y_move){
        this.x_min += x_move;
        this.x_max += x_move;
        this.y_min += y_move;
        this.y_max += y_move;
    }

    public void hidePorts(Canvas canvas){
        for(int i = 0 ; i < this.portsArray.size() ; i++){
            canvas.remove(this.portsArray.get(i));
        }
        portsArray.clear();
        canvas.repaint();
    }
    
    public void moveComponentFront(Canvas canvas) {

    }

    public boolean checkIfOnComponent(int x, int y){
        return false;
    }

    public void changeName(String name){

    }

}
