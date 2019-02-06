package com.company;

public class Board {
    private final String nought = "O";
    private final String cross = "X";

    private final int noRows = 3;
    private final int noCols = 3;
    private String[][] grid;

    public Board()
    {
        this.grid = this.createEmptyBoard();
    }

    public String[][] getGrid()
    {
        return this.grid;
    }

    public void setGrid(String[][] grid)
    {
        this.grid = grid;
    }

    private String[][] createEmptyBoard()
    {
        String[][] grid = new String[this.noRows][this.noCols];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = " ";
            }
        }

        return grid;
    }

    public boolean checkValidMove(int row, int col)
    {

        return this.grid[row][col].equals(" ");
    }

    public boolean checkWin(int playerIndex)
    {
        String c;

        if(playerIndex == 0)
        {
            c = this.nought;
        } else
        {
            c = this.cross;
        }
        boolean win;

        //checks each row
        for(int i = 0; i < this.noCols; i++)
        {
            win = true;
            for(int j = 0; j < this.noRows; j++)
            {
                if(!(this.grid[i][j].equals(c)))
                {
                    win = false;
                }
            }
            if(win) return true;
        }

        //checks each column
        for(int j = 0; j < this.noCols; j++)
        {
            win = true;
            for(int i = 0; i < this.noRows; i++)
            {
                if(!(this.grid[i][j].equals(c)))
                {
                    win = false;
                }
            }
            if(win) return true;
        }

        //checks diagonal
        win = true;

        for(int i = 0; i < this.noRows; i++)
        {
            if(!(this.grid[i][i].equals(c)))
            {
                win = false;
            }
        }
        if(win) return true;

        //checks other diagonal
        win = true;

        for(int i = 0; i < this.noRows; i++)
        {
            if(!(this.grid[i][2 - i].equals(c)))
            {
                win = false;
            }
        }
        if(win) return true;

        return false;
    }

    public boolean checkDraw()
    {
        for(int i = 0; i < this.noRows; i++)
        {
            for(int j = 0; j < this.noCols; j++)
            {
                if(this.grid[i][j].equals(" "))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean updateBoard(int[] coordinate, int playerIndex)
    {
        int row = coordinate[0];
        int col = coordinate[1];

        if(!this.checkValidMove(row, col)) return false;

        if(playerIndex == 0)
        {
            this.grid[row][col] = this.nought;
        } else
        {
            this.grid[row][col] = this.cross;
        }
        return true;
    }

    @Override
    public String toString()
        {
            String toString = "";

            for(int i = 0; i < this.noCols; i++)
            {
                for(int j = 0; j < this.noRows; j++)
                {
                    toString += this.grid[i][j] + " | ";
                }
                toString += "\n----------\n";
            }

            return toString;
    }

}