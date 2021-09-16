package ir.fum.gui.ImplementObjects;

import ir.fum.game.Block;
import ir.fum.game.Player;
import ir.fum.gui.MapPanel;

import java.awt.event.ActionListener;

public abstract class BtnListenerImplementsObjects implements ActionListener {

    private int iNumber;
    private int jNumber;
    private MapPanel panel;
    private Block desiredBlock;

    public Player getPalyerBlock() {
        return palyerBlock;
    }

    public void setPalyerBlock(Player palyerBlock) {
        this.palyerBlock = palyerBlock;
    }

    private Player palyerBlock;

    public int getnClicksLimits() {
        return nClicksLimits;
    }

    public void setnClicksLimits(int nClicksLimits) {
        this.nClicksLimits = nClicksLimits;
    }

    private int nClicksLimits;


    public Block getDesiredBlock() {
        return desiredBlock;
    }

    public void setDesiredBlock(Block desiredBlock) {
        this.desiredBlock = desiredBlock;
    }


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

    public MapPanel getPanel() {
        return panel;
    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }


}
