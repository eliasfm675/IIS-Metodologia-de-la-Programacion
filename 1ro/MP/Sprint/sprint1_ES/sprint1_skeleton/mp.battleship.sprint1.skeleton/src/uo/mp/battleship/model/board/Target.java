package uo.mp.battleship.model.board;

public interface Target {
    Damage shootAt();
    char toChar(boolean isShot);
	char minimalChar(boolean shot);
}
