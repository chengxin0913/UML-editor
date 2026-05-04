package buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JComponent;

//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;

import editor.ButtonPanel;

public class Button extends JButton {
    public Button(ImageIcon icon, int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Color.gray, 2));

        Image tmp = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(tmp);

        this.setIcon(icon);
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setBackground(Color.white);

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAction();
            }
        });
    }

    protected void buttonAction() {
        resetButtonColor();
        Button.this.setBackground(Color.lightGray);
    }

    private void resetButtonColor() {  // reset color of all buttons when one is clicked
        for (int i = 0; i < ButtonPanel.buttonlist.size(); i++) {
            ButtonPanel.buttonlist.get(i).setBackground(Color.white);
        }
    }
}

