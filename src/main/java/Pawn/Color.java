package src.main.java.Pawn;

public enum Color {
    WHITE(-1),
    BLACK(1);
    
    public final int direction;

    public int getDirection() {
        return direction;
    }

    Color(int direction) {
    this.direction = direction;
    }
}




