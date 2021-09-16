package ir.fum.gui;


import ir.fum.game.Block;
import ir.fum.game.BluePlayer;
import ir.fum.game.NormalBlock;
import ir.fum.game.RedPlayer;

import javax.swing.*;
import java.awt.*;


public class MapPanel extends JPanel {

    private InitializeMapButton initializeMapButton;
    private GridLayout board;
    private WestPanel westPanel;
    private Block[][] blocks;
    private int countClicks;
    private BluePlayer bluePlayer;
    private RedPlayer redPlayer;
    private int availableStars;

    public int getAvailableStars() {
        return availableStars;
    }

    public void setAvailableStars(int availableStars) {
        this.availableStars = availableStars;
    }

    public void updateAvailableStars(int availableStars) {
        this.availableStars += availableStars;
    }

    public int getSwitchPanel() {
        return switchPanel;
    }

    public void setSwitchPanel(int switchPanel) {
        this.switchPanel = switchPanel;
    }

    private int switchPanel;

    public BluePlayer getBluePlayer() {
        return bluePlayer;
    }

    public void setBluePlayer(BluePlayer bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

    public RedPlayer getRedPlayer() {
        return redPlayer;
    }

    public void setRedPlayer(RedPlayer redPlayer) {
        this.redPlayer = redPlayer;
    }

    public MapPanel(InitializeMapButton initializeMapButton) {


        this.initializeMapButton = initializeMapButton;
        setAvailableStars(initializeMapButton.getNStars());
        blocks = new Block[initializeMapButton.getNRow()][initializeMapButton.getNColumn()];
        board = new GridLayout(initializeMapButton.getNRow(), initializeMapButton.getNColumn(), 1, 1);
        setBackground(Color.BLUE);

        setLayout(board);
        for (int i = 0; i < initializeMapButton.getNRow(); i++) {
            for (int j = 0; j < initializeMapButton.getNColumn(); j++) {

                blocks[i][j] = new NormalBlock(i, j);

                add(blocks[i][j]);
            }
        }

        westPanel = new WestPanel(this);


    }


    public GridLayout getBoard() {
        return this.board;
    }


    public WestPanel getWestPanel() {
        return this.westPanel;
    }

    public InitializeMapButton getInitializeMapButton() {
        return this.initializeMapButton;
    }

    public Block[][] getBlocks() {
        return this.blocks;
    }

    public int countClicks() {

        return ++countClicks;
    }

    public void resetCountClicls() {

        countClicks = 0;
    }


}







