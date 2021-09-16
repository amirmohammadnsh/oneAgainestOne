package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class OptionScreen extends JFrame {

    public OptionScreen() {
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("oneAgainestOne - Build Game Map");
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        OptionPanel panel = new OptionPanel();
        getContentPane().add(panel);
        getContentPane().add(new InitializeMapButton(panel));


    }


}
