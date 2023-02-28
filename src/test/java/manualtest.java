package src.test.java;

import java.util.Arrays;

public class manualtest {
    public static void main(String[] args) {

        String[][] filed = new String[20][20];
        setWhitePawns(filed, 20);
        setBlackPawns(filed,20);

        for (int i=0; i< filed.length; i++){
            for (int j=0; j<filed[i].length; j++){
                if(filed[i][j]==null){
                    filed[i][j]=" ";
                }
            }
        }

        for (String[] row: filed){
            System.out.println(Arrays.toString(row));
        }



    }
    public static void setWhitePawns(String[][] fields, int n) {
        int whitePawnsNumber = n * 2;
        for (int row = fields.length - 1; row >= 0; row--) {
            if (whitePawnsNumber==0){
                break;
            }
            if ((row - 1) % 2 == 0) {
                for (int i = 0; i < fields[row].length; i += 2) {
                    if (whitePawnsNumber > 0) {
                        fields[row][i] = "O";
                        whitePawnsNumber--;
                    }
                }
            } else {
                for (int i = 1; i < fields[row].length; i += 2) {
                    if (whitePawnsNumber > 0) {
                        fields[row][i] = "0";
                        whitePawnsNumber--;
                    }
                }
            }
        }
    }

    public static void setBlackPawns(String[][] fields, int n) {
        int blackPawnsNumber = n * 2;
        for (int row = 0; row < fields.length; row++) {
            if (blackPawnsNumber==0){
                break;
            }
            if ((row + 1) % 2 == 0) {
                for (int i = 0; i < fields[row].length; i += 2) {
                    if (blackPawnsNumber > 0) {
                        fields[row][i] = "X";
                        blackPawnsNumber--;
                    }
                }
            } else {
                for (int i = 1; i < fields[row].length; i += 2) {
                    if (blackPawnsNumber > 0) {
                        fields[row][i] = "X";
                        blackPawnsNumber--;
                    }
                }
            }
        }
    }

}
