package ir.fum.gui.ImplementObjects;


import ir.fum.game.NormalBlock;
import ir.fum.game.Position;
import ir.fum.game.RedPlayer;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class BtnListenerImplementsRedPlayer extends BtnListenerImplementsObjects {

    private RedPlayer redPlayer;

    public BtnListenerImplementsRedPlayer(int i, int j, MapPanel panel) {
        setiNumber(i);
        setjNumber(j);
        setPanel(panel);
        redPlayer = new RedPlayer(getiNumber(), getjNumber());
        setPalyerBlock(redPlayer);
        setnClicksLimits(1);

    }

    public void actionPerformed(ActionEvent event) {

        Component c = ((Component) event.getSource()).getComponentAt(getiNumber(), getjNumber());
        if (c instanceof NormalBlock) {
            int nClicks = getPanel().countClicks();
            if (nClicks <= getnClicksLimits()) {
                redPlayer.setPosition(new Position(getiNumber(), getjNumber()));
                int componentPosition = getPanel().getComponentZOrder(c);
                getPanel().remove(getPanel().getComponent(componentPosition));
                getPanel().add(getPalyerBlock(), componentPosition);
                redPlayer.setPlayerComponentBlock(componentPosition);
                getPanel().setRedPlayer(redPlayer);
                getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
                getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);

                getPanel().getWestPanel().getFrame().setVisible(true);
//                if (getPanel().getComponentAt(0, 0) instanceof Apple)
//                    System.out.println("Yes");
                if (nClicks == getnClicksLimits()) {
                    getPanel().getWestPanel().getImplementPanel().getStartBattleButton().setEnabled(true);
                    getPanel().getWestPanel().getImplementPanel().getStartBattleButton().setBackground(Color.GREEN);

                }

            }

        }

    }


}
