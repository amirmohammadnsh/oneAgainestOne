package ir.fum.game;

import javax.swing.*;
import java.awt.*;

public class Player extends JButton {
    private int power;
    private int score;
    private Position position;
    private int eatenStars;

    public int getEatenStars() {
        return eatenStars;
    }

    public void updateEatenStars(int eatenStars) {
        this.eatenStars += eatenStars;
    }

    private int playerComponentBlock;

    public int getPlayerComponentBlock() {
        return playerComponentBlock;
    }

    public void setPlayerComponentBlock(int playerComponentBlock) {
        this.playerComponentBlock = playerComponentBlock;
    }

    public void setPicture() {
        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        ImageIcon imgIcon = new ImageIcon(getImageIconPath());
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        setIcon(image);
        setBackground(Color.WHITE);
    }

    public String getImageIconPath() {
        return imageIconPath;
    }

    public void setImageIconPath(String imageIconPath) {
        this.imageIconPath = imageIconPath;
    }

    private String imageIconPath;


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public void updateScore(int score) {

        this.score += score;

    }

    public void updatePower(int power) {

        this.power += power;

    }


}
