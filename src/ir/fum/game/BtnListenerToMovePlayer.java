package ir.fum.game;

import ir.fum.gui.MapPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListenerToMovePlayer implements ActionListener {

    private int iNumber;
    private int jNumber;
    private final int bluePlayerSelected = 0;
    private final int redPlayerSelected = 1;
    private final int endGame = 3;


    public int getiNumber() {
        return iNumber;
    }

    public void setiNumber(int iNumber) {
        this.iNumber = iNumber;
    }

    public int getjNumber() {
        return jNumber;
    }

    public void setjNumber(int jNumber) {
        this.jNumber = jNumber;
    }

    private MapPanel panel;


    public BtnListenerToMovePlayer(int i, int j, MapPanel panel) {
        setiNumber(i);
        setjNumber(j);
        setPanel(panel);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Component c = ((Component) e.getSource()).getComponentAt(getiNumber(), getjNumber());

        switch (getPanel().getSwitchPanel()) {

            case bluePlayerSelected:

                if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Apple) {

                    Boolean movePermision = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getBluePlayer());
                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof NormalBlock) {
                    Boolean movePermision = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getBluePlayer());


                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Mushroom) {
                    Boolean movePermision = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getBluePlayer());


                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Star) {
                    Boolean movePermision = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getBluePlayer());


                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Wall) {
                    Boolean movePermision = ((Wall) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getBluePlayer());
                }


                break;


            case redPlayerSelected:


                if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Apple) {
                    Boolean movePermision = ((Apple) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getRedPlayer());
                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof NormalBlock) {
                    Boolean movePermision = ((NormalBlock) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getRedPlayer());
                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Mushroom) {
                    Boolean movePermision = ((Mushroom) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getRedPlayer());
                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Star) {

                    Boolean movePermision = ((Star) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();
                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getRedPlayer());


                } else if (getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY()) instanceof Wall) {
                    Boolean movePermision = ((Wall) getPanel().getComponentAt(getPanel().getBlocks()[getiNumber()][getjNumber()].getX(), getPanel().getBlocks()[getiNumber()][getjNumber()].getY())).movePermission();

                    if (movePermision)
                        new GameBrain(c, getPanel(), getiNumber(), getjNumber(), getPanel().getRedPlayer());

                }


                break;
            case endGame:
//                JOptionPane.showMessageDialog(null, "Game Has Ended "
//                        , "Ending Game", JOptionPane.INFORMATION_MESSAGE);
//
//              f  getPanel().getWestPanel().getFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
//                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
//
//                        getPanel().getBlocks()[i][j].setEnabled(false);
//
//                    }
//                }


//               break;
        }


    }

    public MapPanel getPanel() {
        return panel;
    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }


}
