package minijuego.view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameView extends JFrame {
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private JButton targetButton;
    private JPanel gamePanel;

    public GameView() {
        setTitle("Caza el Boton");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Estadisticas
        JPanel statsPanel = new JPanel(new GridLayout(1, 2));
        statsPanel.setBackground(Color.LIGHT_GRAY);
        scoreLabel = new JLabel("Puntos: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timeLabel = new JLabel("Tiempo: 0", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        statsPanel.add(scoreLabel);
        statsPanel.add(timeLabel);
        add(statsPanel, BorderLayout.NORTH);

        // Panel de Juego
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(new Color(40, 40, 40));
        
        targetButton = new JButton("X");
        targetButton.setBackground(Color.RED);
        targetButton.setForeground(Color.WHITE);
        targetButton.setFocusable(false);
        targetButton.setBounds(200, 150, 50, 50);
        
        gamePanel.add(targetButton);
        add(gamePanel, BorderLayout.CENTER);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Puntos: " + score);
    }

    public void updateTime(int time) {
        timeLabel.setText("Tiempo: " + time + "s");
        if (time <= 5) timeLabel.setForeground(Color.RED);
        else timeLabel.setForeground(Color.BLACK);
    }

    public void moveTargetRandomly() {
        Random rand = new Random();
        int maxWidth = gamePanel.getWidth() - targetButton.getWidth();
        int maxHeight = gamePanel.getHeight() - targetButton.getHeight();

        if (maxWidth > 0 && maxHeight > 0) {
            int newX = rand.nextInt(maxWidth);
            int newY = rand.nextInt(maxHeight);
            targetButton.setLocation(newX, newY);
        }
    }

    public JButton getTargetButton() {
        return targetButton;
    }

    public void showGameOverMessage(int finalScore) {
        JOptionPane.showMessageDialog(this, 
            "¡Juego Terminado!\nPuntuacion Final: " + finalScore, 
            "Game Over", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}