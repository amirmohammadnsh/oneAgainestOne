package ir.fum.game;

import javax.swing.*;
import java.awt.*;

public class Wall extends Block {

    private final int wallBlockScore = 0;
    private final int wallBlockPower = 0;

    public Wall(int rowNumber, int columnNumber) {

        this.setPosition(new Position(rowNumber, columnNumber));
        setPicture();
    }

    @Override
    public void setPicture() {
        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        String path = "images\\wall.jpg";
        ImageIcon imgIcon = new ImageIcon(path);
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        setIcon(image);
        setBackground(Color.WHITE);

    }

    public boolean movePermission() {

        return false;
    }

    public int score() {
        return wallBlockScore;
    }

    public int power() {
        return wallBlockPower;
    }


}
