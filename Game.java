package com.company;

public class Game {

    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    private boolean isPlaying;
    private int winner;

    public Game()
    {
        this.board = new Board();
        this.players = this.createPlayers();
    }

    private Player[] createPlayers()
    {
        Player[] players = new Player[2];
        players[0] = new Human(this.board, 0);
        players[1] = new AI(this.board, 1);

        return players;
    }

    public boolean playGame()
    {
        int[] coordinate;
        boolean validMove;

        this.isPlaying = true;
        this.currentPlayerIndex = 0;

        while(this.isPlaying) {
            System.out.println(this.board);

            do
            {
                coordinate = this.players[this.currentPlayerIndex].makeMove();
                validMove = board.updateBoard(coordinate, this.currentPlayerIndex);

                if(!validMove)
                {
                    System.out.println("\nError: slot already taken\n");
                }
            } while(!validMove);

            if(this.board.checkWin(this.currentPlayerIndex))
            {
                this.winner = this.currentPlayerIndex;
                this.isPlaying = false;
            }

            if(this.board.checkDraw())
            {
                this.winner = -1;
                this.isPlaying = false;
            }

            this.currentPlayerIndex = 1 - this.currentPlayerIndex;
        }

        System.out.println(this.board);

        if(this.winner == 0)
        {
            System.out.println("Nought player wins!");
        } else if(this.winner == 1)
        {
            System.out.println("Cross player wins!");
        } else
        {
            System.out.println("Game tied!");
        }

        return true;
    }

}