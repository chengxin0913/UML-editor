package shape;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import editor.Canvas;

public class Line extends Shape{
    protected int firstConnect_PortIndex;
    protected int secondConnect_PortIndex;

    protected Object firstComponent;
    protected Object secondComponent;

    protected Point firstConnect_Point;
    protected Point secondConnect_Point;

    protected JLabel firstConnect_Port;
    protected JLabel secondConnect_Port;

    protected int canvasWidth, canvasHeight;
    protected Point adjustPoint = new Point();

    public Line(Canvas canvas, int first_x, int first_y, int second_x, int second_y, Object firstComponent, Object secondComponent){
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
        
        firstConnect_PortIndex = calClosestPortIndex(first_x, first_y, firstComponent);
        secondConnect_PortIndex = calClosestPortIndex(second_x, second_y, secondComponent);

        firstConnect_Port = new JLabel();
        firstConnect_Port.setOpaque(true);
        firstConnect_Port.setBackground(Color.black);
        canvas.add(firstConnect_Port, 1);

        secondConnect_Port = new JLabel();
        secondConnect_Port.setOpaque(true);
        secondConnect_Port.setBackground(Color.black);
        canvas.add(secondConnect_Port, 1);

    }

    private int calClosestPortIndex(int x, int y, Object obj){
        // up, right, down, left
        int[] PortLoc_X = {obj.x_min + (obj.x_max - obj.x_min) / 2, obj.x_max, obj.x_min + (obj.x_max - obj.x_min) / 2, obj.x_min};
        int[] PortLoc_Y = {obj.y_min, obj.y_min + (obj.y_max - obj.y_min) / 2, obj.y_max, obj.y_min + (obj.y_max - obj.y_min) / 2};

        int Port = 0;
        double min = 100000;
        for(int i = 0 ; i < 4 ; i++){
            double dist = Math.pow(x - PortLoc_X[i], 2) + Math.pow(y - PortLoc_Y[i], 2);
            if(dist < min){
                min = dist;
                Port = i;
            }
        }
        return Port;
    }

    private Point getPortPoint(Object obj, int port){
        int[] PortLoc_X = {obj.x_min + (obj.x_max - obj.x_min) / 2, obj.x_max, obj.x_min + (obj.x_max - obj.x_min) / 2, obj.x_min};
        int[] PortLoc_Y = {obj.y_min, obj.y_min + (obj.y_max - obj.y_min) / 2, obj.y_max, obj.y_min + (obj.y_max - obj.y_min) / 2};
        
        return new Point(PortLoc_X[port], PortLoc_Y[port]);
    }

    @Override
    public void paintMyComponents(Canvas canvas){
        firstConnect_Point = getPortPoint(firstComponent, firstConnect_PortIndex);
        secondConnect_Point = getPortPoint(secondComponent, secondConnect_PortIndex);

        firstConnect_Port.setBounds(firstConnect_Point.x - 5, firstConnect_Point.y - 5, 10, 10);
        secondConnect_Port.setBounds(secondConnect_Point.x - 5, secondConnect_Point.y - 5, 10, 10);
        
        canvasWidth = 585;
        canvasHeight = 460;
    }
}
