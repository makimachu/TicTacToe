package com.cweamshoda.tictactoe;

public class Tile {
    private int x;
    private int y;
    private boolean empty;
    private String character;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.empty = true;
        this.character = "_";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getCharacter() {
        return character;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCharacter(String character) {
        this.character = character;
        this.empty = false;
    }
}
