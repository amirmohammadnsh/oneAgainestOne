package ir.fum.game;

import javax.swing.*;
import java.awt.*;

public class Star extends Block {


    private final int starBlockScore = 1;
    private final int starBlockPower = 0;


    public Star(int rowNumber, int columnNumber) {

        this.setPosition(new Position(rowNumber, columnNumber));
        setPicture();
    }

    public Star() {


        setPicture();
    }


    @Override
    public void setPicture() {
        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        String path = "images\\star.png";
        ImageIcon imgIcon = new ImageIcon(path);
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        setIcon(image);
        setBackground(Color.WHITE);

    }

    public boolean movePermission() {

        return true;
    }

    public int score() {
        return starBlockScore;
    }

    public int power() {
        return starBlockPower;
    }


}
