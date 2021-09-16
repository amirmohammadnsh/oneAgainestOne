package ir.fum.gui.ImplementObjects;

import ir.fum.game.Apple;
import ir.fum.game.NormalBlock;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;


public class BtnListenerImplementsApples extends BtnListenerImplementsObjects {


    public BtnListenerImplementsApples(int i, int j, MapPanel panel) {
        setiNumber(i);
        setjNumber(j);
        setPanel(panel);
        setDesiredBlock(new Apple(getiNumber(), getjNumber()));
        setnClicksLimits(panel.getInitializeMapButton().getNApples());

    }

    public void actionPerformed(ActionEvent event) {

        Component c = ((Component) event.getSource()).getComponentAt(getiNumber(), getjNumber());
        if (c instanceof NormalBlock) {
            int nClicks = getPanel().countClicks();
            if (nClicks <= getnClicksLimits()) {
                int componentPosition = getPanel().getComponentZOrder(c);
                getPanel().remove(getPanel().getComponent(componentPosition));
                getPanel().add(getDesiredBlock(), componentPosition);

                getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
                getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);

                getPanel().getWestPanel().getFrame().setVisible(true);
                if (nClicks == getnClicksLimits()) {
                    getPanel().getWestPanel().getImplementPanel().getMushroomPlaceButton().setEnabled(true);
                    getPanel().getWestPanel().getImplementPanel().getMushroomPlaceButton().setBackground(Color.GREEN);

                }

            }

        }

    }


}
