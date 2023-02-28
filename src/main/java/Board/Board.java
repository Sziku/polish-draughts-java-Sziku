package src.main.java.Board;

import src.main.java.Pawn.Color;
import src.main.java.Pawn.Pawn;

public class Board {
    //private Scanner scanner;
    private int n;

    private  Pawn[][] fields;

    public Board(int n) {
        this.n=n;

        if(n<10){
            this.n=10;
        } else if (n>20) {
            this.n=20;
        }

        fields=new Pawn[this.n][this.n];

    }

    public Pawn[][] getFields() {
        return fields;
    }

    public  void removePawn( int x, int y) {

        this.fields[x][y] = null;
    }
    public  void movePawn( int[] coordinates) {
        this.fields[coordinates[1]][coordinates[0]].setPosition(new int[]{coordinates[3], coordinates[2]});
        this.fields[coordinates[3]][coordinates[2]] = this.fields[coordinates[1]][coordinates[0]];

    }

    public void setWhitePawns() {
        int whitePawnsNumber = n * 2;
        for (int row = fields.length - 1; row >= 0; row--) {
            if (whitePawnsNumber==0){
                break;
            }
            if ((row - 1) % 2 == 0) {
                for (int i = 0; i < fields[row].length; i += 2) {
                    if (whitePawnsNumber > 0) {
                        fields[row][i] = new Pawn(Color.WHITE, new int[]{row, i});
                        whitePawnsNumber--;
                    }
                }
            } else {
                for (int i = 1; i < fields[row].length; i += 2) {
                    if (whitePawnsNumber > 0) {
                        fields[row][i] = new Pawn(Color.WHITE, new int[]{row, i});
                        whitePawnsNumber--;
                    }
                }
            }
        }
    }

    public void setBlackPawns() {
        int blackPawnsNumber = n * 2;
        for (int row = 0; row < fields.length; row++) {
            if (blackPawnsNumber==0){
                break;
            }
            if ((row + 1) % 2 == 0) {
                for (int i = 0; i < fields[row].length; i += 2) {
                    if (blackPawnsNumber > 0) {
                        fields[row][i] = new Pawn(Color.BLACK, new int[]{row, i});
                        blackPawnsNumber--;
                    }
                }
            } else {
                for (int i = 1; i < fields[row].length; i += 2) {
                    if (blackPawnsNumber > 0) {
                        fields[row][i] = new Pawn(Color.BLACK, new int[]{row, i});
                        blackPawnsNumber--;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T','U'};
        System.out.print("      ");
        for (int i = 0; i < n; i++){
            System.out.print(abc[i]+"     ");
        }
        System.out.println();
        result+="   "+"|-----".repeat(n)+"|"+"\n";

        for (int i = 0; i < fields.length; i++) {
            if (i<9){
                result += i + 1 + "  |";
            } else {
                result += i + 1 + " |";
            }

            for (int j = 0; j < fields[i].length; j++) {

                if (fields[i][j] == null) {

                    result += "     |";
                } else if (fields[i][j].getColor().equals(Color.BLACK)) {
                    result += "  X  |";
                } else {
                    result += "  O  |";
                }
            }
            result += "\n";
            result+="   "+"|-----".repeat(n)+"|"+"\n";




        }
        return result;
    }
}

/*
    Print ötlet -Sziku
            A     B     C     D     E     F     G     H     I     J
         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
       1 |  X  |     |  X  |     |  X  |     |  X  |     |  X  |     |
         |-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
       2 |   | X |   | X |   | X |   | X |   | X |
         |---|---|---|---|---|---|---|---|---|---|
       3 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       4 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       5 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       6 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       7 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       8 |   |   |   |   |   |   |   |   |   |   |
         |---|---|---|---|---|---|---|---|---|---|
       9 |   | O |   | O |   | O |   | O |   | O |
         |---|---|---|---|---|---|---|---|---|---|
      10 | O |   | O |   | O |   | O |   | O |   |
         |---|---|---|---|---|---|---|---|---|---|
*/
