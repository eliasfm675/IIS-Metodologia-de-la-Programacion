package uo.mp.battleship.model.board;

import uo.mp.util.check.ArgumentChecks;

public class Ship implements Target {
    private int size;
    private int shotCount;

    public Ship(int size) {
    	ArgumentChecks.isTrue(size>=1 && size<=4, "Size's argument is invalid");
        this.size = size;
        this.shotCount = 0;
    }

    @Override
    public Damage shootAt() {
        shotCount++;
        return shotCount >= size ? Damage.MASSIVE_DAMAGE : Damage.SEVERE_DAMAGE;
    }

    @Override
    public char toChar(boolean isShot) {
        if (!isShot) {
            switch (size) {
                case 1:
                    return 'S';
                case 2:
                    return 'D';
                case 3:
                    return 'C';
                case 4:
                    return 'B';
            }
        } else {
            return toFiredChar();
        }
        return ' '; // Default to blank space
    }

    public int size() {
        return size;
    }

    public boolean isSunk() {
        return shotCount >= size;
    }

    public char toFiredChar() {
        return isSunk() ? '#' : '*';
    }
    public char minimalChar(boolean isShot) {
    	if(isShot) {
    		return toFiredChar();
    	}else {
    		return ' ';
    	}
    }
}

