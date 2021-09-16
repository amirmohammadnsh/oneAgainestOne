package ir.fum.gui;

import ir.fum.game.Apple;
import ir.fum.game.BluePlayer;
import ir.fum.game.RedPlayer;
import ir.fum.game.Star;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ScorePanel extends JPanel {

    private JButton WhiteButton;
    private BluePlayer bluePlayer;
    private RedPlayer redPlayer;
    private Apple apple;
    private Star star;

    public BluePlayer getBluePlayer() {
        return bluePlayer;
    }

    public RedPlayer getRedPlayer() {
        return redPlayer;
    }

    public Apple getApple() {
        return apple;
    }

    public Star getStar() {
        return star;
    }

    private JTextField bluePlayerAppleNumber;
    private JTextField redPlayerAppleNumber;
    private JTextField bluePlayerStarNumber;
    private JTextField redPlayerStarNumber;
    private JButton setOrder;
    private JButton bluePlayerOrder;
    private JButton redPlayerOrder;

    public JButton getBluePlayerOrder() {
        return bluePlayerOrder;
    }

    public JButton getRedPlayerOrder() {
        return redPlayerOrder;
    }

    public JTextField getBluePlayerAppleNumber() {
        return bluePlayerAppleNumber;
    }

    public JTextField getRedPlayerAppleNumber() {
        return redPlayerAppleNumber;
    }

    public JTextField getBluePlayerStarNumber() {
        return bluePlayerStarNumber;
    }

    public JTextField getRedPlayerStarNumber() {
        return redPlayerStarNumber;
    }

    public ScorePanel() {
        Font font = new Font("Courier", Font.BOLD, 20);
        setLayout(new GridLayout(4, 3));
        setBorder(new LineBorder(Color.GREEN, 4));
        WhiteButton = new JButton();
        WhiteButton.setBackground(Color.BLUE);
        WhiteButton.setSize(40, 40);
        WhiteButton.setEnabled(false);
        bluePlayer = new BluePlayer();
        bluePlayer.setEnabled(false);

        redPlayer = new RedPlayer();
        redPlayer.setEnabled(false);
        apple = new Apple();
        apple.setEnabled(false);
        bluePlayerAppleNumber = new JTextField("");
        bluePlayerAppleNumber.setBackground(Color.WHITE);
        bluePlayerAppleNumber.setEnabled(false);
        bluePlayerAppleNumber.setHorizontalAlignment(JTextField.CENTER);
        bluePlayerAppleNumber.setText(Integer.toString(0));
        bluePlayerAppleNumber.setFont(font);

        redPlayerAppleNumber = new JTextField("");
        redPlayerAppleNumber.setText(Integer.toString(0));
        redPlayerAppleNumber.setBackground(Color.WHITE);
        redPlayerAppleNumber.setEnabled(false);
        redPlayerAppleNumber.setHorizontalAlignment(JTextField.CENTER);
        redPlayerAppleNumber.setFont(font);

        star = new Star();
        star.setEnabled(false);
        bluePlayerStarNumber = new JTextField("");
        bluePlayerStarNumber.setText(Integer.toString(0));
        bluePlayerStarNumber.setBackground(Color.WHITE);
        bluePlayerStarNumber.setEnabled(false);
        bluePlayerStarNumber.setHorizontalAlignment(JTextField.CENTER);
        bluePlayerStarNumber.setFont(font);

        redPlayerStarNumber = new JTextField("");
        redPlayerStarNumber.setText(Integer.toString(0));
        redPlayerStarNumber.setBackground(Color.WHITE);
        redPlayerStarNumber.setEnabled(false);
        redPlayerStarNumber.setHorizontalAlignment(JTextField.CENTER);
        redPlayerStarNumber.setFont(font);

        setOrder = new JButton("Order");
        setOrder.setBackground(Color.ORANGE);
        setOrder.setEnabled(false);

        bluePlayerOrder = new JButton();
        bluePlayerOrder.setSize(40, 40);
        bluePlayerOrder.setBackground(Color.RED);
        bluePlayerOrder.setEnabled(false);
        redPlayerOrder = new JButton();
        redPlayerOrder.setSize(40, 40);
        redPlayerOrder.setBackground(Color.RED);
        redPlayerOrder.setEnabled(false);
        add(WhiteButton);
        add(bluePlayer);
        add(redPlayer);
        add(apple);
        add(bluePlayerAppleNumber);
        add(redPlayerAppleNumber);
        add(star);
        add(bluePlayerStarNumber);
        add(redPlayerStarNumber);
        add(setOrder);
        add(bluePlayerOrder);
        add(redPlayerOrder);
        setVisible(true);


    }


}
