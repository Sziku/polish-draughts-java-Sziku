package src.main.java;

import src.main.java.Game.Game;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int player = 0;
        int win = 0;
        boolean stop = true;
        String[] userInput = new String[1];
        int[] coordintes = new int[4];
        enum State {
            INI, PRINT, VALIDMOVE, MOVE, WON, END, VALIDUSERINPUT
        }
        State activeState = State.INI;
        while (stop) {
            Scanner scanner = new Scanner(System.in);
            switch (activeState) {
                case INI -> {
                    Util.printMsg("Welcome the game. Please set a board size between 10 and 20");
                    Util.printMsg("Board size:");

                    int boardSize = scanner.nextInt();
                    Game.start(boardSize); //elindítja a játékot ini-ja a tábla méretét

                    activeState = State.PRINT;
                }
                case PRINT -> {
                    System.out.println(Game.getCurrentGame());
                    activeState = State.VALIDUSERINPUT;
                }

                case VALIDUSERINPUT -> {
                    Game.playRound(player, win);
                    userInput[0] = scanner.nextLine();
                    if (Util.stringChecking(userInput[0])) {
                        if (userInput[0].equals("quit") || userInput[0].equals("q")) {
                            activeState = State.END;
                        } else {
                            activeState = State.VALIDMOVE;
                        }
                    }
                }

                case VALIDMOVE -> {
                    coordintes = Util.UserCoordToArrayCoord(userInput[0]);
                    if (Game.tryToMakeMove(coordintes,player)) {
                        activeState = State.MOVE;
                    } else {
                        Util.printErrorMsg("Wrong move");
                        activeState = State.VALIDUSERINPUT;
                    }
                }

                case MOVE -> {

                    Game.getCurrentGame().movePawn(coordintes);
                    Game.getCurrentGame().removePawn(coordintes[1], coordintes[0]);
                    if (Math.abs(coordintes[1] - coordintes[3]) == 2) {
                        int col;
                        if (coordintes[0] - coordintes[2] < 0) {
                            col = coordintes[0] + 1;
                        } else {
                            col = coordintes[0] - 1;
                        }
                        if (player == 0) {
                            Game.getCurrentGame().removePawn(coordintes[1] - 1, col);
                        }
                        if(player==1){
                            Game.getCurrentGame().removePawn(coordintes[1] + 1, col);
                        }


                    }
                    activeState = State.WON;
                }

                case WON -> {
                    if (Game.checkForWinner(player,Game.getCurrentGame().getFields())) {
                        if (player == 0) {
                            win = 1;
                        } else {
                            win = 2;
                        }

                        Game.playRound(player, win);

                        activeState = State.END;
                    } else {
                        if (player == 0) {
                            player = 1;
                        } else {
                            player = 0;
                        }
                        activeState = State.PRINT;
                    }
                }

                case END -> {
                    Util.printMsg("Game end");
                    scanner.close();
                    stop = false;
                }
            }
        }
    }
}
