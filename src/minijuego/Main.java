package minijuego;

import minijuego.model.GameModel;
import minijuego.view.GameView;
import minijuego.controller.GameController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel(30); // Tiempo de la Ronda
            GameView view = new GameView();

            new GameController(model, view);
            
            view.setVisible(true);
        });
    }
}