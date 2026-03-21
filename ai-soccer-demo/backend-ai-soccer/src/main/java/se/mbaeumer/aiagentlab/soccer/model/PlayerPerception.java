package se.mbaeumer.aiagentlab.soccer.model;

public class PlayerPerception {

    private double distanceToBall;
    private double distanceToGoal;
    private double closestOpponentDistance;
    private boolean hasBall;
    
    public double getDistanceToBall() {
        return distanceToBall;
    }

    public void setDistanceToBall(double distanceToBall) {
        this.distanceToBall = distanceToBall;
    }

    public double getDistanceToGoal() {
        return distanceToGoal;
    }

    public void setDistanceToGoal(double distanceToGoal) {
        this.distanceToGoal = distanceToGoal;
    }

    public double getClosestOpponentDistance() {
        return closestOpponentDistance;
    }

    public void setClosestOpponentDistance(double closestOpponentDistance) {
        this.closestOpponentDistance = closestOpponentDistance;
    }

    public boolean isHasBall() {
        return hasBall;
    }

    public void setHasBall(boolean hasBall) {
        this.hasBall = hasBall;
    }
}