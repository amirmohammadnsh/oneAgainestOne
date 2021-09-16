package ir.fum.game;

import ir.fum.gui.MapPanel;

public class RedPlayer extends Player {

    public RedPlayer(int rowNumber, int columnNumber) {
        setImageIconPath("images\\RedPlayer.png");
        setPosition(new Position(rowNumber, columnNumber));
        setScore(0);
        setPower(1);
        setPicture();

    }

    public RedPlayer(int rowNumber, int columnNumber, int score, int power, int playerComponentBlock, MapPanel panel) {

        panel.getRedPlayer().setPosition(new Position(rowNumber, columnNumber));
        panel.getRedPlayer().setPlayerComponentBlock(playerComponentBlock);
        panel.getRedPlayer().updatePower(power);
        panel.getRedPlayer().updateScore(score);
        setImageIconPath(panel.getRedPlayer().getImageIconPath());
        setPicture();

    }

    public RedPlayer() {
        setImageIconPath("images\\RedPlayer.png");

        setPicture();

    }
}