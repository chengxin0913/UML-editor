package buttons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundBorder implements Border{
    public Insets getBorderInsets(Component c){
        return new Insets(0, 0, 0, 0);
    }
    public boolean isBorderOpaque(){
        return false;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 20, 20);
    }
}