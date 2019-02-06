package com.company;

import java.util.Scanner;

public class Player {
    public Scanner reader;
    private Board board;
    private int index;

    public Player(Board board, int index)
    {
        this.reader = new Scanner(System.in);
        this.board = board;
        this.index = index;
    }

    public Board getBoard()
    {
        return this.board;
    }

    public int getIndex()
    {
        return this.index;
    }

    private String[][] copyGrid(String[][] grid)
    {
        String[][] clone = new String[3][3];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                clone[i][j] = grid[i][j];
            }
        }

        return clone;
    }

    public Board copyBoard(Board board)
    {
        String[][] cloneGrid = this.copyGrid(board.getGrid());

        Board cloneBoard = new Board();
        cloneBoard.setGrid(cloneGrid);

        return cloneBoard;
    }

    public boolean checkValid(int num)
    {
        return num >= 0 && num <= 2;
    }

    public int[] makeMove()
    {
        int[] coordinate = new int[2];
        return coordinate;
    }

}