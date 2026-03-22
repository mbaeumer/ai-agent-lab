package se.mbaeumer.aiagentlab.soccer.model;

public class Player {

    private String name;
    private PlayerRole role;
    private Position position;
    private boolean hasBall;

    public Player(String name, PlayerRole role, Position position) {
        this.name = name;
        this.role = role;
        this.position = position;
        this.hasBall = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasBall() {
        return hasBall;
    }

    public void setHasBall(boolean hasBall) {
        this.hasBall = hasBall;
    }

    public PlayerRole getRole() {
        return role;
    }

    public Position getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Direction direction) {
        this.position = new Position(
                (int) (this.position.x() + direction.deltaX()),
                (int) (this.position.y() + direction.deltaY())
        );
    }

}
