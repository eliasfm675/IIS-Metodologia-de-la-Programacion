package uo.mp.battleship.model.board;

import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class Coordinate {
    static final int MIN_GRID_SIZE = 10;
    private static final int MAX_GRID_SIZE = 20;
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        ArgumentChecks.isTrue(x >= 0 && y >= 0 && x < MAX_GRID_SIZE && y < MAX_GRID_SIZE,
                "X or Y position is an invalid value for the argument");
        this.x = x;
        this.y = y;
    }

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Coordenada [x = %d, y = %d]", getCol(), getRow());
    }

    public String toUserString() {
        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
        return characters[getCol()] + "-" + (getRow() + 1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate other = (Coordinate) obj;
        return x == other.x && y == other.y;
    }

    public Coordinate go(Direction direction) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case NORTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY++;
                break;
            case WEST:
                newX--;
                break;
            default:
                return null;
        }

        newX = Math.max(0, Math.min(newX, MAX_GRID_SIZE - 1));
        newY = Math.max(0, Math.min(newY, MAX_GRID_SIZE - 1));

        return new Coordinate(newX, newY);
    }
}
