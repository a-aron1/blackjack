package com.wordle;

/*
 *
 */

import com.wordle.LangCheck;

import java.io.IOException;
import java.util.ArrayList;

public class Board {
    // statics


    // fields
    private int rowCount;
    private int colCount;
    private ArrayList<String> guesses = new ArrayList<String>();
    private String answer;
    private LangCheck wordCheck;

    // Ctors
    public Board(String filePath) throws IOException {
        this.rowCount = 6;
        this.colCount = 5;
        this.wordCheck = new LangCheck(filePath, 5);
    }

    public Board(String filePath, int size) throws IOException {
        this.rowCount = size;
        this.colCount = 5;
        this.wordCheck = new LangCheck(filePath, 5);
    }

    public Board(String filePath, int size, int length) throws IOException {
        this.rowCount = size;
        this.colCount = length;
        this.wordCheck = new LangCheck(filePath, length);
        this.answer = wordCheck.fetchRandomWord();
    }

    // business methods
    public void guess(String str) {
        if (str.length() == getBoardWidth() && answer.equals(str)) {
            guesses.add(str);
        }
    }

    // derived accessors
    public int getGuessCount() {
        return guesses.size();
    }

    public final String getGuessNum(int num) {
        return guesses.get(num);
    }

    public boolean hasWon() {
        return guesses.contains(getAnswer());
    }

    public boolean isGameOver() {
        return hasWon() || getGuessCount() == getBoardHeight();
    }

    // accessors
    public final String getAnswer() {
        return answer;
    }

    public int getBoardHeight() { // from getRowCount
        return rowCount;
    }

    public int getBoardWidth() { // from getColCount
        return colCount;
    }
}