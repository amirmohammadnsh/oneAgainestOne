package ir.fum.gui;

import javax.swing.*;
import java.awt.*;


public class MapFrame extends JFrame {

    private JPanel westPanel;
    private JPanel eastPanel;
    private ScorePanel scorePanel;

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void setScorePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public MapFrame(WestPanel westPanel) {
        setSize(1200, 640);
        setResizable(false);
        setLayout(new BorderLayout());


//        panel.setBorder(new LineBorder(Color.RED,3));
//        add(panel, BorderLayout.WEST);
//        add(new ImplementPanel(panel.getInitializeMapButton()), BorderLayout.SOUTH);

//       eastPanel = new JPanel();
//       eastPanel.setBackground(Color.GREEN);
//       eastPanel.setSize(1000,500);
        add(westPanel, BorderLayout.WEST);
        ScorePanel scorePanel = new ScorePanel();
        setScorePanel(scorePanel);
        add(getScorePanel(), BorderLayout.EAST);
//        add(eastPanel, BorderLayout.EAST);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }


}
