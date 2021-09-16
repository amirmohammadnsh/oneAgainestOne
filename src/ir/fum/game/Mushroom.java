package ir.fum.game;

import javax.swing.*;
import java.awt.*;

public class Mushroom extends Block {

    private final int mushroomBlockScore = 0;
    private final int mushroomBlockPower = -1;


    public Mushroom(int rowNumber, int columnNumber) {
        this.setPosition(new Position(rowNumber, columnNumber));
        setPicture();
    }

    @Override
    public void setPicture() {
        setSize(40, 40);
        setMargin(new Insets(0, 0, 0, 0));
        String path = "images\\Mushroom.png";
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
        return mushroomBlockScore;
    }

    public int power() {
        return mushroomBlockPower;
    }


}
