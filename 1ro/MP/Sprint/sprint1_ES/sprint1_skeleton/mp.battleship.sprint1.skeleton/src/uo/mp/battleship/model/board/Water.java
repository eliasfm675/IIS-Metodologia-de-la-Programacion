package uo.mp.battleship.model.board;

public class Water implements Target {
    @Override
    public Damage shootAt() {
        return Damage.NO_DAMAGE;
    }

    @Override
    public char toChar(boolean isShot) {
        return isShot ? toFiredChar() : ' ';
    }
    public char minimalChar(boolean isShot) {
    	return isShot ? toFiredChar() : ' ';
    }

    public char toFiredChar() {
        return 'Ø';
    }
}
