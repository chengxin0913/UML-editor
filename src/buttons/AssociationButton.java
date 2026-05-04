package buttons;

import javax.swing.ImageIcon;

import editor.EditorFrame;
import mode.AssociationLineMode;

public class AssociationButton extends Button{
    public AssociationButton(ImageIcon icon, int x, int y, int width, int height){
        super(icon, x, y, width, height);
    }

    @Override
    protected void buttonAction(){
        super.buttonAction();
        EditorFrame.setCurrentMode(new AssociationLineMode());
    }
}