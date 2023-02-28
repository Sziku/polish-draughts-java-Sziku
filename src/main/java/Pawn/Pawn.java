package src.main.java.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Pawn {
    private final Color color;
    private Coordinates position;
    private boolean crowned;
    private List<List<Integer>> possibleMoves;

    public Pawn(Color color, int[] coordinates) {
        this.color = color;
        position = new Coordinates(coordinates);
    }

    public Color getColor() {
        return color;
    }


    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int[] coord) {
        this.position.setCoordinates(coord);
    }


    public int[][] getPossibleMove(Pawn[][] pawns) {
        return null;
    }

    public boolean validateMove(int[] destenation, Pawn[][] pawns, Pawn pawn) {
        return false;
    }

    public void setPossibleMoveBySziku(Pawn[][] pawns) {
        List<List<Integer>> avaibleMove = new ArrayList<>();
        int pawnX = position.getCoordinates()[0];
        int pawnY = position.getCoordinates()[1];
        int color = this.color.getDirection();

        try {
            if (pawns[pawnX + color][pawnY - color] == null) {
                List<Integer> goodCoords = new ArrayList<>();
                goodCoords.add(pawnX + color);
                goodCoords.add(pawnY - color);
                avaibleMove.add(goodCoords);
            } else {
                if (!pawns[pawnX + color][pawnY - color].getColor().equals(this.color)) {
                    if(pawns[pawnX + color*2][pawnY - color*2] == null){
                        List<Integer> goodCoords = new ArrayList<>();
                        goodCoords.add(pawnX + color * 2);
                        goodCoords.add(pawnY - color * 2);
                        avaibleMove.add(goodCoords);
                    }

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        try {
            if (pawns[pawnX + color][pawnY + color] == null) {
                List<Integer> goodCoords = new ArrayList<>();
                goodCoords.add(pawnX + color);
                goodCoords.add(pawnY + color);
                avaibleMove.add(goodCoords);
            } else {
                if (!pawns[pawnX + color][pawnY + color].getColor().equals(this.color)) {
                    if (pawns[pawnX + color * 2][pawnY + color * 2] == null) {
                        List<Integer> goodCoords = new ArrayList<>();
                        goodCoords.add(pawnX + color * 2);
                        goodCoords.add(pawnY + color * 2);
                        avaibleMove.add(goodCoords);
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
        this.possibleMoves = avaibleMove;
    }

    public List<List<Integer>> getPossibleMoveBySziku() {

        return possibleMoves;
    }
}
