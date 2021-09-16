package ir.fum.gui.ImplementObjects;

import ir.fum.game.*;
import ir.fum.gui.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StartBattleButton extends JButton implements ActionListener {

    private MapPanel panel;

    private BtnListenerToMovePlayer BtnToMovePlayer;

    public MapPanel getPanel() {
        return panel;
    }

    public void setPanel(MapPanel panel) {
        this.panel = panel;
    }

    public StartBattleButton(MapPanel panel) {
        setText("Start Battle");
        setBackground(Color.RED);
        setEnabled(false);
        setPanel(panel);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int c = 0;
                disableButton();
                getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayer().setEnabled(true);
                getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayer().setEnabled(true);
                getPanel().getWestPanel().getFrame().getScorePanel().getApple().setEnabled(true);
                getPanel().getWestPanel().getFrame().getScorePanel().getStar().setEnabled(true);


                getPanel().setSwitchPanel(new Random().nextInt(3) % 2);
                if (getPanel().getSwitchPanel() == 0) {
                    JOptionPane.showMessageDialog(null, "Game will be started\n First Move is For Blue Player "
                            , "Starting Game", JOptionPane.INFORMATION_MESSAGE, new Pictures().bluePlayerImage);
                    getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.GREEN);
                    getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.RED);
                } else if (getPanel().getSwitchPanel() == 1) {
                    JOptionPane.showMessageDialog(null, "Game will be started\n First Move is For Red Player "
                            , "Starting Game", JOptionPane.INFORMATION_MESSAGE, new Pictures().redPlayerImage);
                    getPanel().getWestPanel().getFrame().getScorePanel().getBluePlayerOrder().setBackground(Color.RED);
                    getPanel().getWestPanel().getFrame().getScorePanel().getRedPlayerOrder().setBackground(Color.GREEN);
                }
                for (int i = 0; i < getPanel().getInitializeMapButton().getNRow(); i++) {
                    for (int j = 0; j < getPanel().getInitializeMapButton().getNColumn(); j++) {
                        ActionListener al[] = (getPanel().getBlocks())[i][j].getActionListeners();
                        (getPanel().getBlocks())[i][j].removeActionListener(al[0]);
                        if (getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()) instanceof Apple ||
                                getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()) instanceof Mushroom ||
                                getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()) instanceof Star ||
                                getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()) instanceof Wall ||
                                getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY()) instanceof NormalBlock) {

//                            System.out.println((getPanel().getBlocks()[i][j].getY() / getPanel().getBlocks()[i][j].getHeight()) + " " + getPanel().getBlocks()[i][j].getX() / getPanel().getBlocks()[i][j].getWidth());
//                            c++;
                            BtnToMovePlayer = new BtnListenerToMovePlayer(i, j, getPanel());
//                            System.out.println(i + " " + j);
                            ((Block) getPanel().getComponentAt(getPanel().getBlocks()[i][j].getX(), getPanel().getBlocks()[i][j].getY())).addActionListener(BtnToMovePlayer);
//
                        }

                    }


                }
//                System.out.println(c);

                getPanel().resetCountClicls();


            }

        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public void disableButton() {

        setBackground(Color.RED);
        setEnabled(false);
    }


}
