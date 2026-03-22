package se.mbaeumer.aiagentlab.soccer.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PlayerPerception {

  private double distanceToBall;
  private double distanceToGoal;
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

  public boolean isHasBall() {
    return hasBall;
  }

  public void setHasBall(boolean hasBall) {
    this.hasBall = hasBall;
  }

  public String toJson() {
    ObjectMapper mapper = new ObjectMapper();
    try {
      String json = mapper.writeValueAsString(this);
      System.out.println(json);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
