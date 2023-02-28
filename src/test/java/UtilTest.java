package src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import src.main.java.Game.Game;
import src.main.java.Pawn.Color;
import src.main.java.Pawn.Pawn;
import src.main.java.Util;

import java.util.Arrays;

class UtilTest {

    @Test
    void stringChecking() {

        String test2 = "1234";
        String test3 = "12 34";
        String test4 = "A1A2";
        String test5 = "A1 A2";
        String test6 = "AA AA";
        String test7 = "A1AA2";
        String test8 = "a1 a2";
        String test9 = "quit";
        String test10 = "q";
        String test11 = "A1 A12";
        String test12 = "A11 A12";
        String test13 = "A111 A2";
        String test14 = "A1 A2A";


        assertFalse(Util.stringChecking("12345678"));
        assertFalse(Util.stringChecking(test2));
        assertFalse(Util.stringChecking(test3));
        assertFalse(Util.stringChecking(test4));
        assertTrue(Util.stringChecking(test5));
        assertFalse(Util.stringChecking(test6));
        assertFalse(Util.stringChecking(test7));
        assertTrue(Util.stringChecking(test8));
        assertTrue(Util.stringChecking(test9));
        assertTrue(Util.stringChecking(test10));
        assertTrue(Util.stringChecking(test11));
        assertTrue(Util.stringChecking(test12));
        assertFalse(Util.stringChecking(test13));
        assertFalse(Util.stringChecking(test14));


    }

    @Test
    void convertChecking() {
        String test1 = "A1 A2";
        String test2 = "A1 B4";
        String test3 = "d1 c2";
        String test4 = "d11 c2";
        String test5 = "d11 c22";
        int[] Arraytest1 = {0, 0, 0, 1};
        int[] Arraytest2 = {0, 0, 1, 3};
        int[] Arraytest3 = {3, 0, 2, 1};
        int[] Arraytest4 = {3, 10, 2, 1};
        int[] Arraytest5 = {3, 10, 2, 21};

        assertEquals(Arrays.toString(Arraytest1), Arrays.toString(Util.UserCoordToArrayCoord(test1)));
        assertEquals(Arrays.toString(Arraytest2), Arrays.toString(Util.UserCoordToArrayCoord(test2)));
        assertEquals(Arrays.toString(Arraytest3), Arrays.toString(Util.UserCoordToArrayCoord(test3)));
        assertEquals(Arrays.toString(Arraytest4), Arrays.toString(Util.UserCoordToArrayCoord(test4)));
        assertEquals(Arrays.toString(Arraytest5), Arrays.toString(Util.UserCoordToArrayCoord(test5)));
        System.out.println(Arrays.toString(Util.UserCoordToArrayCoord(test1)));
        System.out.println(Arrays.toString(Util.UserCoordToArrayCoord(test2)));
        System.out.println(Arrays.toString(Util.UserCoordToArrayCoord(test3)));
        System.out.println(Arrays.toString(Util.UserCoordToArrayCoord(test4)));
        System.out.println(Arrays.toString(Util.UserCoordToArrayCoord(test5)));
    }

    @Test
    void gameEnd() {
        Pawn testBlack = new Pawn(Color.BLACK, new int[]{1, 1});
        Pawn testWhite = new Pawn(Color.WHITE, new int[]{1, 1});

        Pawn[][] pawn1 = {{null, testBlack, null}, {null, null, null}, {null, null, testWhite}};
        Pawn[][] pawn2 = {{null, null, null}, {null, null, null}, {null, null, testWhite}};
        int player1 = 0;
        int player2 = 1;

        assertFalse(Game.checkForWinner(player1, pawn1));
        assertTrue(Game.checkForWinner(player1, pawn2));
        assertFalse(Game.checkForWinner(player2, pawn2));
    }
}