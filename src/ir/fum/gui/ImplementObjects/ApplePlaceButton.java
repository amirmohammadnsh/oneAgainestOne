package ir.fum.gui.ImplementObjects;

import ir.fum.game.Pictures;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplePlaceButton extends PlaceImplementButton {

    private BtnListenerImplementsApples BtnApples;


    public ApplePlaceButton(MapPanel panel) {
        initButton();
        setPanel(panel);
        setEnabled(true);
        setBackground(Color.GREEN);
        setComponentLimit(panel.getInitializeMapButton().getNApples());
        setTextButton("Place Apples");
        setComponentName("Apples");
        setImageIcon(new Pictures().appleImage);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                disableButton();

                viewDialog(getComponentLimit(), getComponentName(), getImageIcon());

                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
//                        System.out.println((getPanel().getBlocks())[i][j].getPosition().getRowNumber()+" "+
//                                (getPanel().getBlocks())[i][j].getPosition().getColumnNumber());

                        BtnApples = new BtnListenerImplementsApples((getPanel().getBlocks())[i][j].getPosition().getRowNumber(),
                                (getPanel().getBlocks())[i][j].getPosition().getColumnNumber(), getPanel());
                        (getPanel().getBlocks())[i][j].addActionListener(BtnApples);


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
