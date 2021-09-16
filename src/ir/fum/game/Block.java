package ir.fum.game;

import javax.swing.*;


public abstract class Block extends JButton {


    private Position position = new Position();


    public abstract void setPicture();

    public abstract boolean movePermission();

    public abstract int score();

    public abstract int power();

    public void setPosition(Position position) {

        this.position.setRowNumber(position.getRowNumber());
        this.position.setColumnNumber(position.getColumnNumber());
    }

    public Position getPosition() {
        return position;
    }


}
