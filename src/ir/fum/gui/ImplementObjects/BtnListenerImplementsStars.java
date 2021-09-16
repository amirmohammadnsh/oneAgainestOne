package ir.fum.gui.ImplementObjects;


import ir.fum.game.NormalBlock;
import ir.fum.game.Star;
import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class BtnListenerImplementsStars extends BtnListenerImplementsObjects {

    public BtnListenerImplementsStars(int i, int j, MapPanel panel) {
        setiNumber(i);
        setjNumber(j);
        setPanel(panel);
        setDesiredBlock(new Star(getiNumber(), getjNumber()));
        setnClicksLimits(panel.getInitializeMapButton().getNStars());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Component c = ((Component) e.getSource()).getComponentAt(getiNumber(), getjNumber());
        if (c instanceof NormalBlock) {
            int nClicks = getPanel().countClicks();
            if (nClicks <= getnClicksLimits()) {

//            System.out.println(c.getY() / c.getHeight() + " " +
//                    c.getX() / c.getWidth() + " " +
//                    this.iNumber + " " + this.jNumber + " " + this.panel.getComponentZOrder(c));
                int componentPosition = getPanel().getComponentZOrder(c);
                getPanel().remove(getPanel().getComponent(componentPosition));
//        this.panel.revalidate();
//        this.panel.repaint();
                getPanel().add(getDesiredBlock(), componentPosition);

//        this.panel.revalidate();
//        this.panel.repaint();
                getPanel().getWestPanel().add(getPanel(), BorderLayout.NORTH);
                getPanel().getWestPanel().getFrame().add(getPanel().getWestPanel(), BorderLayout.WEST);

                getPanel().getWestPanel().getFrame().setVisible(true);
//                if (getPanel().getComponentAt(0, 0) instanceof Apple)
//                    System.out.println("Yes");
//                System.out.println("Yes");
                if (nClicks == getnClicksLimits()) {
                    getPanel().getWestPanel().getImplementPanel().getWallPlaceButton().setEnabled(true);
                    getPanel().getWestPanel().getImplementPanel().getWallPlaceButton().setBackground(Color.GREEN);

                }

            }

        }


    }
}
