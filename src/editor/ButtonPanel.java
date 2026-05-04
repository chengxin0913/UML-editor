package editor;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import buttons.*;


public class ButtonPanel extends JPanel{
    public int sideButtonNumber = 0;
    public static ArrayList<Button> buttonlist = new ArrayList<Button>();
    private Button select_btn, association_btn, generalization_btn, composition_btn, class_btn, useclass_btn;

    public ButtonPanel(){
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        final int x = 20;
        final int y = 20;
        final int gap = 30;
        final int btn_width = 70;
        final int btn_height = 60;

        select_btn = new SelectButton(new ImageIcon("resource/select.png"), x, y, btn_width, btn_height);
        this.add(select_btn);
        buttonlist.add(select_btn);
        sideButtonNumber += 1;

        association_btn = new AssociationButton(new ImageIcon("resource/association.png"), x, y + gap + btn_height, btn_width, btn_height);
        this.add(association_btn);
        buttonlist.add(association_btn);
        sideButtonNumber += 1;

        generalization_btn = new GeneralizationButton(new ImageIcon("resource/generalizationline.png"), x, y + 2*(gap+btn_height), btn_width, btn_height);
        this.add(generalization_btn);
        buttonlist.add(generalization_btn);
        sideButtonNumber += 1;
        
        composition_btn = new CompositionButton(new ImageIcon("resource/compositionline.png"), x, y + 3*(gap+btn_height), btn_width, btn_height);
        this.add(composition_btn);
        buttonlist.add(composition_btn);
        sideButtonNumber += 1;

        class_btn = new ClassButton(new ImageIcon("resource/class.png"), x, y + 4*(gap+btn_height), btn_width, btn_height);
        this.add(class_btn);
        buttonlist.add(class_btn);
        sideButtonNumber += 1;

        useclass_btn = new UseCaseButton(new ImageIcon("resource/useclass.png"), x, y + 5*(gap+btn_height), btn_width, btn_height);
        this.add(useclass_btn);
        buttonlist.add(useclass_btn);
        sideButtonNumber += 1;
    }
}