package ir.fum.game;

import ir.fum.gui.MapPanel;

public class BluePlayer extends Player {

    public BluePlayer(int rowNumber, int columnNumber) {
        setImageIconPath("images\\BluePlayer.jpg");
        setPosition(new Position(rowNumber, columnNumber));
        setScore(0);
        setPower(1);
        setPicture();

    }

    public BluePlayer(int rowNumber, int columnNumber, int score, int power, int playerComponentBlock, MapPanel panel) {

        panel.getBluePlayer().setPosition(new Position(rowNumber, columnNumber));
        panel.getBluePlayer().setPlayerComponentBlock(playerComponentBlock);
        panel.getBluePlayer().updatePower(power);
        panel.getBluePlayer().updateScore(score);
        setImageIconPath(panel.getBluePlayer().getImageIconPath());
        setPicture();


    }

    public BluePlayer() {
        setImageIconPath("images\\BluePlayer.jpg");
        setPicture();

    }


}
