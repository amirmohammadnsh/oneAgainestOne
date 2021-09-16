package ir.fum.gui.ImplementObjects;

import ir.fum.game.Apple;
import ir.fum.game.BluePlayer;
import ir.fum.game.NormalBlock;
import ir.fum.game.Position;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class BtnListenerImplementsBluePlayer extends BtnListenerImplementsObjects {

    private BluePlayer bluePlayer;


    public BtnListenerImplementsBluePlayer(int i, int j, MapPanel panel) {
        setiNumber(i);
        setjNumber(j);
        setPanel(panel);
        bluePlayer = new BluePlayer(getiNumber(), getjNumber());
        setPalyerBlock(bluePlayer);
        setnClicksLimits(1);

    }

    public void actionPerformed(ActionEvent event) {

        Component c = ((Component) event.getSource()).getComponentAt(getiNumber(), getjNumber());
        if (c instanceof NormalBlock) {
            int nClicks = getPanel().countClicks();
            if (nClicks <= getnClicksLimits()) {
                bluePlayer.setPosition(new Position(getiNumber(), getjNumber()));
                int componentPosition = getPanel().getComponentZOrder(c);
                getPanel().remove(getPanel().getComponent(componentPosition));
                getPanel().add(getPalyerBlock(), componentPosition);
                bluePlayer.setPlayerComponentBlock(componentPosition);
                getPanel().setBluePlayer(bluePlayer);
                getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
                getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);

                getPanel().getWestPanel().getFrame().setVisible(true);
                if (getPanel().getComponentAt(0, 0) instanceof Apple)
                    System.out.println("Yes");
                if (nClicks == getnClicksLimits()) {
                    getPanel().getWestPanel().getImplementPanel().getRedPlayerPlaceButton().setEnabled(true);
                    getPanel().getWestPanel().getImplementPanel().getRedPlayerPlaceButton().setBackground(Color.GREEN);


                }

            }

        }

    }


}
