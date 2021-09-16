package ir.fum.gui;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JFrame {




    public NewGame() {
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("oneAgainestOne");
        setLayout(new FlowLayout());
        getContentPane(). setBackground(Color.YELLOW);
        setVisible(true);
        NewGameButton newGameButton = new NewGameButton();
        add(newGameButton);

    }






}
