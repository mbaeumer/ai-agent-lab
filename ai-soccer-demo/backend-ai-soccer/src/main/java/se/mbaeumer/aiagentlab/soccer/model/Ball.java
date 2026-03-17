package se.mbaeumer.aiagentlab.soccer.model;

public class Ball {
    private Position position;

    public Ball(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
