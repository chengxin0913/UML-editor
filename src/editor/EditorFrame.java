package editor;

import java.awt.Color;


import javax.swing.*;
import mode.Mode;

public class EditorFrame extends JFrame{
    private JFrame frame = new JFrame("xyz");
    public static ButtonPanel btn_panel = new ButtonPanel();
    public static Canvas canvas = new Canvas();
    private static MenuBar menu_bar = new MenuBar();

    final int canvas_wdith =  (int)(1.4 * ((60 * ButtonPanel.buttonlist.size()) + (30 * (ButtonPanel.buttonlist.size()-1))));
    final int canvas_height = (60 * ButtonPanel.buttonlist.size()) + (30 * (ButtonPanel.buttonlist.size()-1));

    public EditorFrame(){
        

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setLayout(null);
        frame.setJMenuBar(menu_bar);

        final int btn_panel_width = 20 + 70 + 20;
        final int btn_panel_height = 20 + (60 * ButtonPanel.buttonlist.size()) + (30 * (ButtonPanel.buttonlist.size()-1)) + 20;
        
        final int frame_width = btn_panel_width + canvas_wdith + 35;
        final int frame_height = btn_panel_height + 60;

        btn_panel.setLocation(0, 0);
        btn_panel.setSize(btn_panel_width, btn_panel_height);
        btn_panel.setBorder(null);
        //btn_panel.setBackground(Color.black);
        frame.add(btn_panel);

        canvas.setLocation(btn_panel_width, 20);
        canvas.setSize(canvas_wdith, canvas_height);
        frame.add(canvas);

        frame.setSize(frame_width, frame_height);
        frame.setVisible(true);
    }

    public static void setCurrentMode(Mode m){
        Canvas.currentMode = m;
    }

    public static void menuSetGroupComponent(){
        canvas.setGroupComponents();
    }

    public static void menuRemoveGroupComponent(){
        canvas.removeGroupComponent();
    }

    public static void menuChangeName(){
        Object obj_Name = JOptionPane.showInputDialog(null, "Enter object name:", "Change Object Name", 0, null, null, "");
        if (obj_Name != null)
            canvas.selectedComponent.changeName(obj_Name.toString());
    }

    public static void setEditMenuGroup(boolean b){
        menu_bar.editmenu_Group.setEnabled(b);
    }

    public static void setEditMenuUnGroup(boolean b){
        menu_bar.editmenu_Ungroup.setEnabled(b);
    }
    public static void setMEditMenuChangeName(boolean b){
        menu_bar.editmenu_ChangeObjectName.setEnabled(b);
    }
    
}