package minijuego.model;

public class GameModel {
    private int score;
    private int timeLeft;
    private final int maxTime;

    public GameModel(int seconds) {
        this.maxTime = seconds;
        reset();
    }

    public void reset() {
        this.score = 0;
        this.timeLeft = maxTime;
    }

    public void incrementScore() {
        this.score += 10;
    }

    public void decreaseTime() {
        if (this.timeLeft > 0) {
            this.timeLeft--;
        }
    }

    public boolean isGameOver() {
        return this.timeLeft <= 0;
    }

    public int getScore() { return score; }
    public int getTimeLeft() { return timeLeft; }
}