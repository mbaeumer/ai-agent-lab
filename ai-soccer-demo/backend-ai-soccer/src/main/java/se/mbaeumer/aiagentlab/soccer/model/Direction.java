package se.mbaeumer.aiagentlab.soccer.model;

public class Direction {
    private double deltaX;
    private double deltaY;

    private Direction(double deltaX, double deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static Direction fromPositions(Position from, Position to) {
        double deltaX = to.x() - from.x();
        double deltaY = to.y() - from.y();
        return new Direction(deltaX, deltaY);
    }

    public Direction getNormalized() {
        double length = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        if (length == 0) {
            return new Direction(0, 0);
        }
        return new Direction(deltaX / length, deltaY / length);
    }

    public Direction scale(double factor) {
        return new Direction(deltaX * factor, deltaY * factor);
    }

    public double deltaX() { return deltaX; }
    public double deltaY() { return deltaY; }
}