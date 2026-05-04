package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import editor.Canvas;
import editor.EditorFrame;

public class AssociationLine extends Line{
    private JComponent lineBody;

    public AssociationLine(Canvas canvas, int first_x, int first_y, int second_x, int second_y, Object firstComponent, Object secondComponent){
        super(canvas, first_x, first_y, second_x, second_y, firstComponent, secondComponent);
        
        lineBody = new JComponent() {
            @Override
            public void paint(Graphics g){
                Graphics2D g_2D = (Graphics2D) g;
                g_2D.setStroke(new BasicStroke(2f));
                g_2D.setBackground(Color.black);
                g_2D.draw(new Line2D.Double(firstConnect_Point.x, firstConnect_Point.y, secondConnect_Point.x, secondConnect_Point.y));
                // x-y coordinate is not as same as normal
                
                double m = ((double)secondConnect_Point.y - (double)firstConnect_Point.y) / ((double)secondConnect_Point.x - (double)firstConnect_Point.x);// x 往右走1, y走多少
                double tmp_x, tmp_y;
                double arrow_len = 10;
                double vec_x = (arrow_len / 1.414) * (1 / (Math.sqrt(Math.pow(m, 2)+1)));
                double vec_y = (arrow_len / 1.414) * (m / (Math.sqrt(Math.pow(m, 2)+1)));
    
                double arrow_x1, arrow_y1, arrow_x2, arrow_y2; 
                if(firstConnect_Point.x > secondConnect_Point.x){
                    //x+
                    tmp_x = secondConnect_Point.x + vec_x;
                    tmp_y = secondConnect_Point.y + vec_y;
                }
                else{
                    //x-
                    tmp_x = secondConnect_Point.x - vec_x;
                    tmp_y = secondConnect_Point.y - vec_y;
                }

                arrow_x1 = tmp_x + vec_y;
                arrow_y1 = tmp_y - vec_x;
                arrow_x2 = tmp_x - vec_y;
                arrow_y2 = tmp_y + vec_x;
                
                //g_2D.setStroke(new BasicStroke(2.5f));
                g_2D.draw(new Line2D.Double(secondConnect_Point.x, secondConnect_Point.y, arrow_x1, arrow_y1));
                g_2D.draw(new Line2D.Double(secondConnect_Point.x, secondConnect_Point.y, arrow_x2, arrow_y2));
                
            }
        };

        canvas.add(lineBody, 1);

        paintMyComponents(canvas);
    }

    @Override
    public void paintMyComponents(Canvas canvas){
        super.paintMyComponents(canvas);
        
        lineBody.setBounds(0, 0, EditorFrame.canvas.getWidth(), EditorFrame.canvas.getHeight());

        canvas.repaint();
    }
}
