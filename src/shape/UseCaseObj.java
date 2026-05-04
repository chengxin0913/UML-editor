package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JLabel;

import editor.Canvas;
import editor.EditorFrame;

public class UseCaseObj extends Object{
    private JComponent oval = new JComponent() {
        @Override
        public void paint(Graphics g){// why 2 level?
            Graphics2D g_2D = (Graphics2D) g;
            g_2D.setColor(Color.black);
            g_2D.fillOval(0, 0, 110, 50);
            g_2D.setStroke(new BasicStroke(5));
            g_2D.setColor(Color.gray);
            g_2D.fillOval(0, 0, 110, 50);
        }
    };

    private JLabel ovalName = new JLabel();

    public UseCaseObj(Canvas canvas, int x, int y){
        this.x_min = x;
        this.x_max = x + 110;
        this.y_min = y;
        this.y_max = y + 50;

        oval.setBounds(x, y, 110, 50);
        ovalName.setBounds(x, y, 110, 50);

        canvas.add(oval, 0);
        canvas.add(ovalName, 0);
        paintMyComponents(canvas);
    }

    @Override
    public void paintMyComponents(Canvas canvas) {
        oval.setBounds(super.x_min, super.y_min, 110, 50);
        ovalName.setBounds(super.x_min, super.y_min, 110, 50);
        canvas.repaint();
    }

    @Override
    public void select(Canvas canvas){
        moveComponentFront(canvas);
        EditorFrame.setMEditMenuChangeName(true);
        canvas.switchTopComponentToArraylistHead(this);
        ShowPorts(canvas);
    }

    @Override
    public boolean checkIfOnComponent(int x, int y){
        if(x >= this.x_min && x <= this.x_max && y >= this.y_min && y <= this.y_max){
            return true;
        }
        return false;
    }

    @Override
    public void changeName(String name){
        ovalName.setFont(new Font(null, Font.PLAIN, 15));
        ovalName.setText(name);
        ovalName.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void moveComponentFront(Canvas canvas){
        canvas.moveToFront(oval);
        canvas.moveToFront(ovalName);
    }
}
