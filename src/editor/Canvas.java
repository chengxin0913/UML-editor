package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import mode.Mode;
import shape.Object;
import shape.GroupObject;
import shape.Line;

public class Canvas extends JLayeredPane{

    public static Mode currentMode = null;

    public ArrayList<Object> selectedtoGroupComponents = new ArrayList<Object>();
    public ArrayList<Object> objectComponents = new ArrayList<Object>();
    public ArrayList<Line> lineComponents = new ArrayList<Line>();

    private Object pressedComponent, releasedComponent;
    public Object selectedComponent;
    private int mousePressX, mousePressY, mouseReleaseX, mouseReleaseY;

    public Canvas(){
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(currentMode == null){
                    return;
                }
                pressAction(e.getX(), e.getY());
            }

            // @Override
            // public void mouseDragged(MouseEvent e) {
            //     // TODO Auto-generated method stub
            //     //super.mouseDragged(e);
            //     System.out.println("jo");
            // }

            @Override
            public void mouseReleased(MouseEvent e){
                if(currentMode == null){
                    return;
                }
                releaseAction(e.getX(), e.getY());
            }
        });

        // this.addMouseMotionListener(new MouseMotionAdapter() {
        //     @Override
        //     public void mouseDragged(MouseEvent e){
        //         dragAction(e.getX(), e.getY());
        //     }
        // });

    }

    private void pressAction(int x, int y){
        mousePressX = x;
        mousePressY = y;
        pressedComponent = checkIfOnComponent(x, y);
    }

    private void dragAction(int x, int y){
        System.out.println("OOO");
    }
    
    private void releaseAction(int x, int y) {
        mouseReleaseX = x;
        mouseReleaseY = y;
        hideAllPorts();
        EditorFrame.setEditMenuUnGroup(false);
        EditorFrame.setMEditMenuChangeName(false);

        releasedComponent = checkIfOnComponent(x, y);
        currentMode.releaseAction(this, pressedComponent, releasedComponent, mousePressX, mousePressY, mouseReleaseX, mouseReleaseY);
    }

    public void hideAllPorts(){
        EditorFrame.setEditMenuGroup(false);
        if(selectedComponent != null){
            selectedComponent.hidePorts(this);
        }
        for(int i = 0 ; i < selectedtoGroupComponents.size() ; i++){
            selectedtoGroupComponents.get(i).hidePorts(this);
        }
        selectedtoGroupComponents.clear();
    }

    public void setGroupComponents(){
        Object groupObject = new GroupObject(selectedtoGroupComponents);
        objectComponents.add(0, groupObject);
    }

    public void removeGroupComponent(){
        for(int i = 0 ; i < objectComponents.size() ; i++){
            if(objectComponents.get(i).equals(selectedComponent)){
                objectComponents.remove(i);
            }
        }
    }

    private Object checkIfOnComponent(int x, int y){
        for(int i = 0 ; i < objectComponents.size() ; i++){
            if(objectComponents.get(i).checkIfOnComponent(x, y)){
                return objectComponents.get(i);
            }
        }
        return null;
    }

    public void switchTopComponentToArraylistHead(Object obj) {
        for (int i = 0; i < objectComponents.size(); i++) {
            if (objectComponents.get(i).equals(obj)) {
                objectComponents.remove(i);
                objectComponents.add(0, obj);
            }
        }
    }
}