package se.mbaeumer.aiagentlab.soccer.model;

public class Goal {
    private Position position;

    public Goal(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
