package com.company;

public class AI extends Player {
    private Board clone;
    private int[] coordinate;

    public AI(Board board, int index)
    {
        super(board, index);
        this.coordinate = new int[2];
    }

    private boolean checkAnyWin(int index)
    {
        boolean validMove;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                this.clone = this.copyBoard(this.getBoard());

                this.coordinate[0] = i;
                this.coordinate[1] = j;

                validMove = this.clone.updateBoard(this.coordinate, index);
                if(validMove)
                {
                    if(this.clone.checkWin(index))
                    {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private boolean checkPlaceCenter()
    {
        this.clone = this.copyBoard(this.getBoard());

        this.coordinate[0] = 1;
        this.coordinate[1] = 1;

        return this.clone.checkValidMove(1, 1);
    }

    private boolean checkPlaceCorner()
    {
        this.clone = this.copyBoard(this.getBoard());

        if(this.clone.checkValidMove(0, 0))
        {
            this.coordinate[0] = 0;
            this.coordinate[1] = 0;
            return true;
        }
        if(this.clone.checkValidMove(0, 2))
        {
            this.coordinate[0] = 0;
            this.coordinate[1] = 2;
            return true;
        }
        if(this.clone.checkValidMove(2, 0))
        {
            this.coordinate[0] = 2;
            this.coordinate[1] = 0;
            return true;
        }
        if(this.clone.checkValidMove(2, 2))
        {
            this.coordinate[0] = 2;
            this.coordinate[1] = 2;
            return true;
        }

        return false;
    }

    private boolean forceMove()
    {
        this.clone = this.copyBoard(this.getBoard());

        if(this.clone.checkValidMove(0, 1))
        {
            this.coordinate[0] = 0;
            this.coordinate[1] = 1;
            return true;
        }
        if(this.clone.checkValidMove(1, 0))
        {
            this.coordinate[0] = 1;
            this.coordinate[1] = 0;
            return true;
        }
        if(this.clone.checkValidMove(1, 2))
        {
            this.coordinate[0] = 1;
            this.coordinate[1] = 2;
            return true;
        }
        if(this.clone.checkValidMove(2, 1))
        {
            this.coordinate[0] = 2;
            this.coordinate[1] = 1;
            return true;
        }

        return false;
    }

    @Override
    public int[] makeMove()
    {
        /**
         * checks if you can win
         * checks if opponent can win
         * attempts to place at center
         * attempts to place at a corner
         * places at one of remaining slots
         */

        if(this.checkAnyWin(this.getIndex())) return this.coordinate;
        if(this.checkAnyWin(1 - this.getIndex())) return this.coordinate;
        if(this.checkPlaceCenter()) return this.coordinate;
        if(this.checkPlaceCorner()) return this.coordinate;

        this.forceMove();
        return this.coordinate;

    }
}
