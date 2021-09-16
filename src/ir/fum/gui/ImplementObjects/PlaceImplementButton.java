package ir.fum.gui.ImplementObjects;


import ir.fum.gui.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class PlaceImplementButton extends JButton implements ActionListener {
    private MapPanel panel;
    private int componentLimit;
    private String componentName;
    private ImageIcon imageIcon;

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public MapPanel getPanel() {
        return panel;
    }

    public void setTextButton(String textButton) {
        setText(textButton);

    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }

    public int getComponentLimit() {
        return componentLimit;
    }

    public void setComponentLimit(int componentLimit) {
        this.componentLimit = componentLimit;
    }

    public void initButton() {
        this.setPanel(panel);
        setEnabled(false);
        setBackground(Color.RED);
        setSize(100, 40);
        setMargin(new Insets(0, 0, 0, 0));


    }

    public void viewDialog(int componentLimit, String componentName, ImageIcon Icon) {

        JOptionPane.showMessageDialog(null, "Please At First Place " +
                componentLimit + " " + componentName, componentName, JOptionPane.INFORMATION_MESSAGE, Icon);


    }


}
