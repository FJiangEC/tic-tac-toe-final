package com.company;

public class Main {

    public static void main(String[] args) {

        boolean status;

        Game game = new Game();
        status = game.playGame();

        if(status)
        {
            System.out.println("----------\nGAME SUCCESSFULLY ENDED");
        } else
        {
            System.out.println("----------\nFATAL ERROR OCCURRED");
        }
    }
}