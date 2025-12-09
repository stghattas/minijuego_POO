package minijuego.controller;

import minijuego.model.GameModel;
import minijuego.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private GameModel model;
    private GameView view;
    private Timer gameTimer;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        this.view.getTargetButton().addActionListener(e -> handleTargetHit());

        // Timer del juego (1000ms = 1 segundo)
        this.gameTimer = new Timer(1000, this);
        
        startGame();
    }

    private void startGame() {
        model.reset();
        view.updateScore(model.getScore());
        view.updateTime(model.getTimeLeft());
        gameTimer.start();
    }

    private void handleTargetHit() {
        if (!model.isGameOver()) {
            model.incrementScore();
            view.updateScore(model.getScore());
            view.moveTargetRandomly();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.decreaseTime();
        view.updateTime(model.getTimeLeft());

        if (model.isGameOver()) {
            gameTimer.stop();
            view.getTargetButton().setEnabled(false);
            view.showGameOverMessage(model.getScore());
        }
    }
}
