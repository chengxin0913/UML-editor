package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBar extends JMenuBar{
    private JMenu file_menu = new JMenu("File");
    private JMenu edit_menu = new JMenu("Edit");

    public JMenuItem editmenu_Group, editmenu_Ungroup, editmenu_ChangeObjectName;

    public MenuBar(){
        editmenu_Group = new JMenuItem("Group");
        editmenu_Ungroup = new JMenuItem("UnGroup");
        editmenu_ChangeObjectName = new JMenuItem("change object name");

        edit_menu.add(editmenu_Group);
        edit_menu.add(editmenu_Ungroup);
        edit_menu.add(editmenu_ChangeObjectName);

        this.add(file_menu);
        this.add(edit_menu);

        editmenu_Group.setEnabled(false);
        editmenu_Group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                EditorFrame.menuSetGroupComponent();
            }
        });

        editmenu_Ungroup.setEnabled(false);
        editmenu_Ungroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                EditorFrame.menuRemoveGroupComponent();
            }
        });

        editmenu_ChangeObjectName.setEnabled(false);
        editmenu_ChangeObjectName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                EditorFrame.menuChangeName();
            }
        });
        
    }
}