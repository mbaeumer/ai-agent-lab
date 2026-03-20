package se.mbaeumer.aiagentlab.soccer.model;

public class Direction {
    private int deltaX;
    private int deltaY;

    private Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static Direction fromPositions(Position from, Position to) {
        int deltaX = to.x() - from.x();
        int deltaY = to.y() - from.y();
        return new Direction(deltaX, deltaY);
    }

    public Direction getNormalized() {
        double length = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        if (length == 0) {
            return new Direction(0, 0);
        }
        return new Direction((int)(deltaX / length), (int)(deltaY / length));
    }



}
