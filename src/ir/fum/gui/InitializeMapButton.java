package ir.fum.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeMapButton extends JButton implements ActionListener {

    OptionPanel panel;
    private int nRow = 0;
    private int nColumn = 0;
    private int nApples = 0;
    private int nMushrooms = 0;
    private int nStars = 0;
    private int nWalls = 0;


    public int getNRow() {
        return nRow;
    }

    public int getNColumn() {
        return nColumn;
    }

    public int getNApples() {
        return nApples;
    }

    public int getNMushrooms() {
        return nMushrooms;
    }

    public int getNStars() {
        return nStars;
    }

    public int getNWalls() {
        return nWalls;
    }

    public InitializeMapButton(OptionPanel panel) {
        setSize(100, 50);
        setText("Initialize Map");
        setRolloverEnabled(true);
        setBackground(Color.GREEN);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (Integer.parseInt(panel.getRowNumber()) < 16 && Integer.parseInt(panel.getColumnNumber()) < 16) {


                    if (Integer.parseInt(panel.getRowNumber()) * Integer.parseInt(panel.getColumnNumber()) - 2 >
                            Integer.parseInt(panel.getAppleNumber()) + Integer.parseInt(panel.getMushroomNumber()) +
                                    Integer.parseInt(panel.getStarNumber()) + Integer.parseInt(panel.getWallumber())) {

                        setNRow(Integer.parseInt(panel.getRowNumber()));
                        setNColumn(Integer.parseInt(panel.getColumnNumber()));
                        setNApples(Integer.parseInt(panel.getAppleNumber()));
                        setNMushrooms(Integer.parseInt(panel.getMushroomNumber()));
                        setNStars(Integer.parseInt(panel.getStarNumber()));
                        setNWalls(Integer.parseInt(panel.getWallumber()));
                        MapPanel mapPanel = new MapPanel(InitializeMapButton.this);

                    } else
                        JOptionPane.showMessageDialog(null, "Sum of things Blocks must be less than " +
                                Integer.parseInt(panel.getRowNumber()) * Integer.parseInt(panel.getColumnNumber()) + " Blocks");
                } else
                    JOptionPane.showMessageDialog(null, "Number Of Rows and Columns must be less than 16  ");
            }
        });
    }

    public void setNRow(int nRow) {
        this.nRow = nRow;
    }

    public void setNColumn(int nColumn) {
        this.nColumn = nColumn;
    }

    public void setNApples(int nApples) {
        this.nApples = nApples;
    }

    public void setNMushrooms(int nMushrooms) {
        this.nMushrooms = nMushrooms;
    }

    public void setNStars(int nStars) {
        this.nStars = nStars;
    }

    public void setNWalls(int nWalls) {
        this.nWalls = nWalls;
    }


    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
