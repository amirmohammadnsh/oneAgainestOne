package ir.fum.gui;

import javax.swing.*;
import java.awt.*;


public class OptionPanel extends JPanel {

    private JTextField rowNumber;
    private JTextField columnNumber;
    private JTextField appleNumber;
    private JTextField mushroomNumber;
    private JTextField starNumber;
    private JTextField wallNumber;


    public OptionPanel() {

        setLayout(new GridLayout(6, 2));
        setBackground(Color.WHITE);
        JLabel rowNumberLable = new JLabel("Number Of Rows : ");
        rowNumber = new JTextField("");
        JLabel columnNumberLable = new JLabel("Number Of Columns : ");
        columnNumber = new JTextField("");
        JLabel appleNumberLable = new JLabel("Number Of Apples : ");
        appleNumber = new JTextField("");
        JLabel mshroomNumberLable = new JLabel("Number Of Mushrooms : ");
        mushroomNumber = new JTextField("");
        JLabel starNumberLable = new JLabel("Number Of Stars : ");
        starNumber = new JTextField("");
        JLabel wallNumberLable = new JLabel("Number Of Walls : ");
        wallNumber = new JTextField("");


        add(rowNumberLable);
        add(rowNumber);

        add(columnNumberLable);
        add(columnNumber);

        add(appleNumberLable);
        add(appleNumber);
        add(mshroomNumberLable);
        add(mushroomNumber);
        add(starNumberLable);
        add(starNumber);
        add(wallNumberLable);
        add(wallNumber);


        setVisible(true);


    }

    public String getRowNumber() {
        return rowNumber.getText();
    }

    public String getColumnNumber() {
        return columnNumber.getText();
    }

    public String getAppleNumber() {
        return appleNumber.getText();
    }

    public String getMushroomNumber() {
        return mushroomNumber.getText();
    }

    public String getStarNumber() {
        return starNumber.getText();
    }

    public String getWallumber() {
        return wallNumber.getText();
    }


}
