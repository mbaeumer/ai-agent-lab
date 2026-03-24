package se.mbaeumer.aiagentlab.soccer.model;

public class Ball {
    private Position position;
    private boolean isInGoal = false;

    public Ball(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Direction direction) {
        this.position = new Position(
                (int) (this.position.x() + direction.deltaX()),
                (int) (this.position.y() + direction.deltaY())
        );
        if (this.position.x() < 0) {
            this.isInGoal = true;
            this.position = new Position(0, this.position.y());
        }
    }

    public boolean isInGoal() {
        return isInGoal;
    }

    public void setInGoal(boolean inGoal) {
        isInGoal = inGoal;
    }
}
