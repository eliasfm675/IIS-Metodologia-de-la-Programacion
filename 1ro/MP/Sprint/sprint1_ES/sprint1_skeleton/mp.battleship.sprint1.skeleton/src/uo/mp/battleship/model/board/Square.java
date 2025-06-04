package uo.mp.battleship.model.board;

public class Square {
    private Target content;
    private boolean shot;

    public Square(Target content) {
        setContent(content);
        this.shot = false;
    }

     Damage shootAt() {
        this.shot = true;
        return content.shootAt();
    }

     boolean isShot() {
        return shot;
    }

     char toChar() {
        return content.toChar(isShot());
    }
     char minimalChar() {
    	 return content.minimalChar(isShot());
     }

     Square setContent(Target target) {
        this.content = target;
        return this;
    }
    public Target getContent() {
    	return content;
    }

     boolean hasContent() {
        return content != null;
    }
}
