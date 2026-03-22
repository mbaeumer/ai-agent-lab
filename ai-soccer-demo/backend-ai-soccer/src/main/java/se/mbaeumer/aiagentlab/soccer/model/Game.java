package se.mbaeumer.aiagentlab.soccer.model;

public class Game {
    private Pitch pitch;
    private Player player;
    private Ball ball;
    private Goal goal;
    private GameStatus gameStatus;

    public Game(Pitch pitch, Player player, Ball ball, Goal goal, GameStatus gameStatus) {
        this.pitch = pitch;
        this.player = player;
        this.ball = ball;
        this.goal = goal;
        this.gameStatus = gameStatus;
    }

    public Pitch getPitch() {
        return pitch;
    }       

    public Player getPlayer() {
        return player;
    }

    public Ball getBall() {
        return ball;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Goal getGoal() {
        return goal;
    }
}
