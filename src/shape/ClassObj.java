package shape;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import editor.Canvas;
import editor.EditorFrame;

public class ClassObj extends Object{
    private ArrayList<JLabel> classLabel = new ArrayList<JLabel>(3);
    
    public ClassObj(Canvas canvas, int x, int y){
        this.x_min = x;
        this.x_max = x + 100;
        this.y_min = y;
        this.y_max = y + 3 * 40;

        for(int i = 0 ; i < 3 ; i++){
            JLabel tmplabel = new JLabel();
            tmplabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            tmplabel.setOpaque(true);
            tmplabel.setBackground(Color.white);
            classLabel.add(tmplabel);
            canvas.add(tmplabel, 0);
        }

        paintMyComponents(canvas);
    }

    @Override
    public void paintMyComponents(Canvas canvas){
        for (int i = 0; i < 3; i++) {
            classLabel.get(i).setBounds(super.x_min, super.y_min + i * 40, 100, 40);
        }
        moveComponentFront(canvas);
        canvas.repaint();
    }
    @Override
    public void select(Canvas canvas){
        EditorFrame.setMEditMenuChangeName(true);
        moveComponentFront(canvas);
        canvas.switchTopComponentToArraylistHead(this);
        ShowPorts(canvas);
    }
    @Override
    public void moveComponentFront(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            canvas.moveToFront(classLabel.get(i));
        }
    }

    @Override
    public boolean checkIfOnComponent(int x, int y){
        if(x >= this.x_min && x <= this.x_max && y >= this.y_min && y <= this.y_max){
            return true;
        }
        return false;
    }
    @Override
    public void changeName(String name) {
        classLabel.get(0).setFont(new Font(null, Font.PLAIN, 15));
        classLabel.get(0).setText(name);
        classLabel.get(0).setHorizontalAlignment(JLabel.CENTER);
    }
}
