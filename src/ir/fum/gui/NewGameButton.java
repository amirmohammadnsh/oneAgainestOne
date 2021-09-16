package ir.fum.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JButton implements ActionListener {

    public NewGameButton() {
        setSize(100, 50);
        setText("New Game");
        setLocation(150, 150);
        setRolloverEnabled(true);
        setBackground(Color.GREEN);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionScreen optionScreen = new OptionScreen();


            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
