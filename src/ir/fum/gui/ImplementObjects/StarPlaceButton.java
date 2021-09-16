package ir.fum.gui.ImplementObjects;

import ir.fum.game.Pictures;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarPlaceButton extends PlaceImplementButton implements ActionListener {


    private BtnListenerImplementsStars BtnStars;


    public StarPlaceButton(MapPanel panel) {

        initButton();
        setPanel(panel);
        setComponentLimit(panel.getInitializeMapButton().getNStars());
        setTextButton("Place Stars");
        setComponentName("Stars");
        setImageIcon(new Pictures().starImage);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableButton();
                viewDialog(getComponentLimit(), getComponentName(), getImageIcon());
                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
                        BtnStars = new BtnListenerImplementsStars(i, j, getPanel());
                        ActionListener al[] = (getPanel().getBlocks())[i][j].getActionListeners();
                        (getPanel().getBlocks())[i][j].removeActionListener(al[0]);
                        (getPanel().getBlocks())[i][j].addActionListener(BtnStars);


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
