package src.main.java.Game;

import src.main.java.Board.Board;
import src.main.java.Pawn.Color;
import src.main.java.Pawn.Pawn;
import src.main.java.Util;

import java.util.List;

public class Game {
    private static  Board[] currentGame = new Board[1];

    public static void start(int tableSize) {
        Board game = new Board(tableSize);
        game.setBlackPawns();
        game.setWhitePawns();
        currentGame[0] = game;
    }

    public static Board getCurrentGame() {
        return currentGame[0];
    }

    public static void playRound(int player, int win) {
        if (win == 0) {
            switch (player) {
                case 0 -> Util.printMsg("Player 1 please set a move");
                case 1 -> Util.printMsg("Player 2 please set a move");
            }
        } else {
            switch (win) {
                case 1 -> Util.printMsg("Player 1 win the game");
                case 2 -> Util.printMsg("Player 2 win the game");
            }
        }

    }

    public static boolean tryToMakeMove(int[] coordinates, int player) {
        if (currentGame[0].getFields()[coordinates[1]][coordinates[0]] != null) {
            if(player==0 && currentGame[0].getFields()[coordinates[1]][coordinates[0]].getColor().equals(Color.WHITE)){
                currentGame[0].getFields()[coordinates[1]][coordinates[0]].setPossibleMoveBySziku(getCurrentGame().getFields());
                for (List<Integer> possibleCords : currentGame[0].getFields()[coordinates[1]][coordinates[0]].getPossibleMoveBySziku()) {
                    if (possibleCords.get(0) == coordinates[3] && possibleCords.get(1) == coordinates[2]) {
                        return true;
                    }
                }
                Util.printErrorMsg("Invalid move");
                return false;
            }else if(player==1 && currentGame[0].getFields()[coordinates[1]][coordinates[0]].getColor().equals(Color.BLACK)){
                currentGame[0].getFields()[coordinates[1]][coordinates[0]].setPossibleMoveBySziku(getCurrentGame().getFields());
                for (List<Integer> possibleCords : currentGame[0].getFields()[coordinates[1]][coordinates[0]].getPossibleMoveBySziku()) {
                    if (possibleCords.get(0) == coordinates[3] && possibleCords.get(1) == coordinates[2]) {
                        return true;
                    }
                }
                Util.printErrorMsg("Invalid move");
                return false;
            }
            else {
                Util.printErrorMsg("That Pawn is not yours");
                return false;
            }

        } else {
            Util.printErrorMsg("Pawn does not exits.");
            return false;
        }
    }

    public static boolean checkForWinner(int player, Pawn[][] pawn) {
        int enemyPawnCounter = 0;
        for (Pawn[] pawns : pawn) {
            for (int j = 0; j < pawn.length; j++) {
                if (pawns[j] != null) {
                    if (player == 0) {
                        if (pawns[j].getColor().equals(Color.BLACK)) {
                            enemyPawnCounter++;
                        }
                    } else {
                        if (pawns[j].getColor().equals(Color.WHITE)) {

                            enemyPawnCounter++;
                        }
                    }
                }
            }
        }

        return enemyPawnCounter < 1;
    }
}
