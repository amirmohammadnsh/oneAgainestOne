package ir.fum.gui;

import ir.fum.gui.ImplementObjects.ImplementPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WestPanel extends JPanel {

    private MapFrame frame;
    private ImplementPanel implementPanel;

    public WestPanel(MapPanel panel) {

        setLayout(new BorderLayout());


        setBorder(new LineBorder(Color.GRAY, 3));

        add(panel, BorderLayout.NORTH);
        implementPanel = new ImplementPanel(panel);
        add(implementPanel, BorderLayout.SOUTH);
        frame = new MapFrame(this);


    }

    public MapFrame getFrame() {
        return this.frame;
    }

    public ImplementPanel getImplementPanel() {
        return this.implementPanel;
    }


}
