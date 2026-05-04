package shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.BasicStroke;

import editor.EditorFrame;
import editor.Canvas;

public class CompositionLine extends Line{
    private int[] compos_dimandx = { 5, 10, 5, 0 };  // x coordinates of composition line shape
    private int[] compos_dimandy = { 0, 5, 10, 5 };  // y coordinates of composition line shape
    
    private int[] xOffsetOfShape = { -5, 5, -5, -15 };
    private int[] yOffsetOfShape = { -15, -5, 5, -5 };

    private int[] xlineLocAdjust = {5, 10, 5, 0};
    private int[] ylineLocAdjust = {0, 5, 10, 5};

    private JComponent lineBody, compLine_shape;
    
    public CompositionLine(Canvas canvas, int first_x, int first_y, int second_x, int second_y, Object firstComponent, Object secondComponent){
        super(canvas, first_x, first_y, second_x, second_y, firstComponent, secondComponent);
        lineBody = new JComponent() {
            @Override
            public void paint(Graphics g){
                Graphics2D g_2D = (Graphics2D) g;
                g_2D.setStroke(new BasicStroke(2f));
                g_2D.setColor(Color.black);
                g_2D.draw(new Line2D.Double(firstConnect_Point.x, firstConnect_Point.y, adjustPoint.x + xlineLocAdjust[secondConnect_PortIndex], adjustPoint.y + ylineLocAdjust[secondConnect_PortIndex]));
            }
        };
        canvas.add(lineBody, 0);

        compLine_shape = new JComponent() {
            @Override
            public void paint(Graphics g) {
                Graphics2D g_2D = (Graphics2D) g;
                g_2D.setColor(Color.white);
                g_2D.fillPolygon(compos_dimandx, compos_dimandy, 4);
                g_2D.setStroke(new BasicStroke(2f));
                g_2D.setColor(Color.black);
                g_2D.drawPolygon(compos_dimandx, compos_dimandy, 4);
            }
        };
        canvas.add(compLine_shape, 1);

        paintMyComponents(canvas);

    }

    @Override
    public void paintMyComponents(Canvas canvas){
        super.paintMyComponents(canvas);
        adjustPoint.setLocation(secondConnect_Point.x + xOffsetOfShape[secondConnect_PortIndex], secondConnect_Point.y + yOffsetOfShape[secondConnect_PortIndex]);
        lineBody.setBounds(0, 0, EditorFrame.canvas.getWidth(), EditorFrame.canvas.getHeight());
        compLine_shape.setBounds(adjustPoint.x, adjustPoint.y, 10, 10);
        canvas.repaint();
    }
}
