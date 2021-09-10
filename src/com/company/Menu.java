package com.company;

import java.util.ArrayList;

public class Menu {

    public static void start(){
        System.out.println("What would you like to do: ");
        System.out.println("(1) Play A Game.\n(2) Exit");
        System.out.print("\nChoice: ");
        int choice = CLI.getNum(1,2);

        if (choice == 1) {
            System.out.println("\nPlease chose a number of Players and number of die each players will toss.");
            System.out.print("\nNumber of Players: ");
            int playerNum = CLI.getNum(2,10);
            System.out.print("\nNumber of Dice: ");
            int playerDice = CLI.getNum(1,10);

            System.out.println("\nNext we will chose a number of Rounds.");
            System.out.print("\nNumber of Rounds: ");
            int roundNum = CLI.getNum(1,10);

            System.out.println("\nOkay so now lets start the game.");
            Game newGame = new Game(playerNum,roundNum,playerDice);
        }else {
            System.out.println("Okay maybe next time, come back soon");
        }


    }

    public static void proceed(){
        System.out.println("\nWhat would you like to do: ");
        System.out.println("(1) Play Again.\n(2) Exit");
        System.out.print("\nChoice: ");
        int choice = CLI.getNum(1,2);

        if (choice == 1) {
            System.out.println("Welcome Back, lets get started.");
            start();
        }else {
            System.out.println("Good Game, come back soon");
        }
    }


}
/*
        The program should have a main menu where the user can play the game or exit the program
           -When the game starts it will ask how many players are playing and how many dice will be thrown.
           -Minimum players of 2 and a max players of 10
           -Min die 1 max die 10
           -then ask how many rounds: min rounds 1, max rounds 10.
           -then each player will get to enter their name one at a time.
           -after that the game will start and each player will roll their die/dice.
           -after everyone has rolled the round ends.
           -the die rolls will total up at the end of each round who ever has the greatest total at the end wins
*/