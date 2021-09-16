package ir.fum.gui.ImplementObjects;


import ir.fum.gui.MapPanel;

import javax.swing.*;
import java.awt.*;

public class ImplementPanel extends JPanel {

    private ApplePlaceButton applePlaceButton;
    private MushroomPlaceButton mushroomPlaceButton;
    private StarPlaceButton starPlaceButton;
    private WallPlaceButton wallPlaceButton;
    private BluePlayerPlaceButtton bluePlayerPlaceButtton;
    private RedPlayerPlaceButton redPlayerPlaceButton;

    public StartBattleButton getStartBattleButton() {
        return startBattleButton;
    }


    private StartBattleButton startBattleButton;


    public ImplementPanel(MapPanel panel) {
        setBackground(Color.GRAY);
        applePlaceButton = new ApplePlaceButton(panel);
        mushroomPlaceButton = new MushroomPlaceButton(panel);
        starPlaceButton = new StarPlaceButton(panel);
        wallPlaceButton = new WallPlaceButton(panel);
        bluePlayerPlaceButtton = new BluePlayerPlaceButtton(panel);
        redPlayerPlaceButton = new RedPlayerPlaceButton(panel);
        startBattleButton = new StartBattleButton(panel);


        setLayout(new GridLayout(3, 3));
        add(applePlaceButton);
        add(mushroomPlaceButton);
        add(starPlaceButton);
        add(wallPlaceButton);
        add(bluePlayerPlaceButtton);
        add(redPlayerPlaceButton);
        add(startBattleButton);


    }


    public ApplePlaceButton getApplePlaceButton() {
        return applePlaceButton;
    }

    public MushroomPlaceButton getMushroomPlaceButton() {
        return mushroomPlaceButton;
    }

    public StarPlaceButton getStarPlaceButton() {
        return starPlaceButton;
    }

    public WallPlaceButton getWallPlaceButton() {
        return wallPlaceButton;
    }

    public BluePlayerPlaceButtton getBluePlayerPlaceButtton() {
        return bluePlayerPlaceButtton;
    }

    public RedPlayerPlaceButton getRedPlayerPlaceButton() {
        return redPlayerPlaceButton;
    }


}
