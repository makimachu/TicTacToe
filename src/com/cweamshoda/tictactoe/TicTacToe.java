package com.cweamshoda.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    private static final List<Tile> tileList = new ArrayList<>();
    private static final Scanner playerInput = new Scanner(System.in);
    private static int playerMove = 0;
    private static boolean gameOver = false;

    public static void main(String[] args) {
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                Tile tile = new Tile(x, y);
                tileList.add(tile);
                System.out.println("Initializing new tile at (" + x + ", " + y + ")"); // Debug
            }
        }
        System.out.println("Player 1's move (x)");
        playGame();
    }

    /**
     * Runs the game
     */
    public static void playGame() {
        getBoard();

        while (!gameOver) {
            int x = playerInput.nextInt();
            int y = playerInput.nextInt();

            if (getTile(x, y) != null && !getTile(x, y).isEmpty()) {
                System.out.println("That tile is not empty");
                playGame();
                return;
            }

            if (getPlayerMove()) {
                setCharacter(x, y, "x");
                System.out.println("Player 1's move (o)");
            } else {
                setCharacter(x, y, "o");
                System.out.println("Player 2's move (x)");
            }

            /* Board layout
            0:0, 0:1, 0:2
            1:0, 1:1, 1:2
            2:0, 2:1, 2:2
            */
            getBoard();
            ++playerMove;

            // TODO: 10/17/2022 Play again option?
            isGameOver();
        }
    }

    /**
     * Prints out the board with updated tiles
     */
    public static void getBoard() {
        System.out.println("  0   1   2");
        System.out.println("0 " + getCharacter(getTile(0, 0)) + " | " + getCharacter(getTile(0, 1)) + " | " + getCharacter(getTile(0, 2)));
        System.out.println("1 " + getCharacter(getTile(1, 0)) + " | " + getCharacter(getTile(1, 1)) + " | " + getCharacter(getTile(1, 2)));
        System.out.println("2 " + getCharacter(getTile(2, 0)) + " | " + getCharacter(getTile(2, 1)) + " | " + getCharacter(getTile(2, 2)));
    }

    /**
     * @param x Board position on the x-axis
     * @param y Board position on the y-axis
     * @return Tile at position x and y
     */
    public static Tile getTile(int x, int y) {
        for (Tile tiles : tileList) {
            if (tiles.getX() == x && tiles.getY() == y) {
                return tiles;
            }
        }
        return null;
    }

    /**
     * @return boolean value to determine player one or player two's move
     */
    public static boolean getPlayerMove() {
        return playerMove % 2 == 0;
    }

    /**
     * Runs loops to check if any player won the game
     */
    public static void isGameOver() {
        boolean threeInARow = false;
        String winner = "";

        for (int x = 0; x < 3; ++x) {
            if (getCharacter(getTile(x, 0)).equalsIgnoreCase("x")
                    && getCharacter(getTile(x, 1)).equalsIgnoreCase("x")
                    && getCharacter(getTile(x, 2)).equalsIgnoreCase("x")) {
                threeInARow = true;
                winner = "x";
            }
        }

        if (!threeInARow) {
            for (int y = 0; y < 3; ++y) {
                if (getCharacter(getTile(0, y)).equalsIgnoreCase("x")
                        && getCharacter(getTile(1, y)).equalsIgnoreCase("x")
                        && getCharacter(getTile(2, y)).equalsIgnoreCase("x")) {
                    threeInARow = true;
                    winner = "x";
                }
            }
        }

        if (!threeInARow) {
            if (getCharacter(getTile(0, 0)).equalsIgnoreCase("x")
                    && getCharacter(getTile(1, 1)).equalsIgnoreCase("x")
                    && getCharacter(getTile(2, 2)).equalsIgnoreCase("x")) {
                threeInARow = true;
                winner = "x";
            }
        }

        if (!threeInARow) {
            if (getCharacter(getTile(0, 0)).equalsIgnoreCase("y")
                    && getCharacter(getTile(1, 1)).equalsIgnoreCase("y")
                    && getCharacter(getTile(2, 2)).equalsIgnoreCase("y")) {
                threeInARow = true;
                winner = "y";
            }
        }

        if (!threeInARow) {
            if (getCharacter(getTile(0, 2)).equalsIgnoreCase("x")
                    && getCharacter(getTile(1, 1)).equalsIgnoreCase("x")
                    && getCharacter(getTile(2, 0)).equalsIgnoreCase("x")) {
                threeInARow = true;
                winner = "x";
            }
        }

        if (!threeInARow) {
            if (getCharacter(getTile(0, 2)).equalsIgnoreCase("y")
                    && getCharacter(getTile(1, 1)).equalsIgnoreCase("y")
                    && getCharacter(getTile(2, 0)).equalsIgnoreCase("y")) {
                threeInARow = true;
                winner = "y";
            }
        }

        if (threeInARow) {
            gameOver = true;
            System.out.println("Game over! Winner is " + winner);
        }
    }

    /**
     * @param tile Tile that you want to get the character from
     * @return Tile's character; x or o
     */
    public static String getCharacter(Tile tile) {
        if (tile == null) return "";
        return tile.getCharacter();
    }

    /**
     * @param x Board position on the x-axis
     * @param y Board position on the y-axis
     * @param newCharacter The new character that the tile will display
     */
    public static void setCharacter(int x, int y, String newCharacter) {
        if (newCharacter.equalsIgnoreCase("x") || !newCharacter.equalsIgnoreCase("y")) {
            getTile(x, y).setCharacter(newCharacter);
            System.out.println("Setting position (" + x + ", " + y + ") to " + newCharacter);
        }
    }
}
