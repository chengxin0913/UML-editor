package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import editor.Canvas;
import editor.EditorFrame;

public class GenerationLine extends Line{

    private JComponent lineBody, geneLine_shape;
    private int[][] gene_trianglex = { { 0, 10, 5 },  // x coordinates of composition line shape
        { 0, 10, 10 },
        { 5, 10, 0 },
        { 0, 10, 0 } };
    private int[][] gene_triangley = { { 0, 0, 10 },  // y coordinates of composition line shape
        { 5, 0, 10 },
        { 0, 10, 10 },
        { 0, 5, 10 } };

    private int[] xOffsetOfShape = { -5, 5, -5, -15 };// up right down left
    private int[] yOffsetOfShape = { -15, -5, 5, -5 };

    private int[] xlineLocAdjust = {5, 10, 5, 0};
    private int[] ylineLocAdjust = {0, 5, 10, 5};

    public GenerationLine(Canvas canvas, int first_x, int first_y, int second_x, int second_y, Object firstComponent, Object secondComponent){
        super(canvas, first_x, first_y, second_x, second_y, firstComponent, secondComponent);
        
        lineBody = new JComponent() {// line body
            @Override
            public void paint(Graphics g){
                Graphics2D g_2D = (Graphics2D) g;
                g_2D.setStroke(new BasicStroke(2f));
                g_2D.setColor(Color.black);
                g_2D.draw(new Line2D.Double(firstConnect_Point.x, firstConnect_Point.y, adjustPoint.x + xlineLocAdjust[secondConnect_PortIndex], adjustPoint.y + ylineLocAdjust[secondConnect_PortIndex]));
            }
        };
        canvas.add(lineBody, 0);

        geneLine_shape = new JComponent() {//arrow
            @Override
            public void paint(Graphics g){
                Graphics2D g_2D = (Graphics2D) g;
                g_2D.setColor(Color.white);
                g_2D.fillPolygon(gene_trianglex[secondConnect_PortIndex], gene_triangley[secondConnect_PortIndex], 3);
                g_2D.setStroke(new BasicStroke(2f));
                g_2D.setColor(Color.black);
                g_2D.drawPolygon(gene_trianglex[secondConnect_PortIndex], gene_triangley[secondConnect_PortIndex], 3);
            }
        };
        canvas.add(geneLine_shape, 1);
        paintMyComponents(canvas);
    }

    @Override
    public void paintMyComponents(Canvas canvas){
        super.paintMyComponents(canvas);
        adjustPoint.setLocation(secondConnect_Point.x + xOffsetOfShape[secondConnect_PortIndex], secondConnect_Point.y + yOffsetOfShape[secondConnect_PortIndex]);
        lineBody.setBounds(0, 0, EditorFrame.canvas.getWidth(), EditorFrame.canvas.getHeight());
        geneLine_shape.setBounds(adjustPoint.x, adjustPoint.y, 10, 10);
        canvas.repaint();
    }
}
