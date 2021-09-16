package ir.fum.gui.ImplementObjects;

import ir.fum.game.Pictures;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MushroomPlaceButton extends PlaceImplementButton implements ActionListener {


    private BtnListenerImplementsMushrooms BtnMushrooms;


    public MushroomPlaceButton(MapPanel panel) {

        initButton();
        setPanel(panel);
        setComponentLimit(panel.getInitializeMapButton().getNMushrooms());
        setTextButton("Place Mushrooms");
        setComponentName("Mushrooms");
        setImageIcon(new Pictures().mushroomImage);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableButton();
                viewDialog(getComponentLimit(), getComponentName(), getImageIcon());
                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
                        BtnMushrooms = new BtnListenerImplementsMushrooms(i, j, getPanel());
                        ActionListener al[] = (getPanel().getBlocks())[i][j].getActionListeners();
                        (getPanel().getBlocks())[i][j].removeActionListener(al[0]);
                        (getPanel().getBlocks())[i][j].addActionListener(BtnMushrooms);


                    }


                }
                getPanel().resetCountClicls();


            }
        });


    }


    public void disableButton() {

        setBackground(Color.RED);
        setEnabled(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
