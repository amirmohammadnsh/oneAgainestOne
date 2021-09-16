package ir.fum.game;


import javax.swing.*;
import java.awt.*;

public class Apple extends Block {

    private final int appleBlockScore = 0;
    private final int appleBlockPower = 1;

    public Apple(int rowNumber, int columnNumber) {

        this.setPosition(new Position(rowNumber, columnNumber));
        setPicture();
    }

    public Apple() {


        setPicture();
    }


    @Override
    public void setPicture() {
        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        String path = "images\\Apple.png";
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
        return appleBlockScore;
    }

    public int power() {
        return appleBlockPower;
    }


}
