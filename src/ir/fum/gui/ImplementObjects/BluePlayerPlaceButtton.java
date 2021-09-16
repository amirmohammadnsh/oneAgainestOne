package ir.fum.gui.ImplementObjects;

import ir.fum.game.Pictures;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BluePlayerPlaceButtton extends PlaceImplementButton {

    private BtnListenerImplementsBluePlayer BtnBluePlayer;


    public BluePlayerPlaceButtton(MapPanel panel) {
        initButton();
        setPanel(panel);
        setComponentLimit(1);
        setTextButton("Place Blue Player");
        setComponentName("Blue Player");
        setImageIcon(new Pictures().bluePlayerImage);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                disableButton();

                viewDialog(getComponentLimit(), getComponentName(), getImageIcon());

                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
                        BtnBluePlayer = new BtnListenerImplementsBluePlayer(i, j, getPanel());
                        ActionListener al[] = (getPanel().getBlocks())[i][j].getActionListeners();
                        (getPanel().getBlocks())[i][j].removeActionListener(al[0]);
                        (getPanel().getBlocks())[i][j].addActionListener(BtnBluePlayer);


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
