package com.company;

public class Human extends Player {

    public Human(Board board, int index)
    {
        super(board, index);
    }

    @Override
    public int[] makeMove()
    {
        int[] coordinate = new int[2];
        boolean validMove;

        do
        {
            System.out.print("Input row (0-2): ");
            coordinate[0] = Integer.parseInt(reader.nextLine());
            validMove = this.checkValid(coordinate[0]);

            if(!validMove)
            {
                System.out.println("Error: invalid position");
            }
        } while(!validMove);

        do
        {
            System.out.print("Input column (0-2): ");
            coordinate[1] = Integer.parseInt(reader.nextLine());
            validMove = this.checkValid(coordinate[1]);

            if(!validMove)
            {
                System.out.println("Error: invalid position");
            }
        } while(!validMove);

        return coordinate;
    }
}