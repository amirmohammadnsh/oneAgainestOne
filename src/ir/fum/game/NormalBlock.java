package ir.fum.game;


import javax.swing.*;
import java.awt.*;

public class NormalBlock extends Block {
    private int normalBlockScore = 0;
    private int normalBlockPower = 0;


    public NormalBlock(int rowNumber, int columnNumber) {
        this.setPosition(new Position(rowNumber, columnNumber));
        setPicture();
    }


    @Override
    public void setPicture() {

        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        String path = "images\\Way.jpg";
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
        return normalBlockScore;
    }

    public int power() {
        return normalBlockPower;
    }


}
