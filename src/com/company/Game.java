package com.company;

import java.util.ArrayList;

public class Game {

    public static ArrayList<Player> players = new ArrayList<>();
    private int numOfRounds;
    private int numOfDice;
    private Player winner;
    public int currentRound = 0;
    public int currentTurn= 0;

    public Game(int numOfPlayers, int numOfRounds, int numOfDice) {
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
        generatePlayers(numOfPlayers);
        displayPlayers();
        playRound();
    }

    public void playRound() {

        if (currentRound > numOfRounds){
            //TODO enter game over
            return;
        }

        for (int i = 0; i < players.size(); i++) {
            playerTurn(i);

        }
        currentRound++;
        currentTurn = 0;

//        choice = options();
//
//        if (choice == 1){
//            playRound();
//        }else if (choice == 2){
//            leaderBoard();
//        }else if (choice == 3){
//            System.out.println();
//        }

    }

    public void playerTurn(int turn ) {
        String name = players.get(turn).getPlayerName();
        System.out.println(name + " it is your turn to roll");
        ArrayList<Integer> rollScores = new ArrayList<Integer>();
        Die die = new Die();
        rollScores = die.rollDie(numOfDice);

        StringBuilder sb = new StringBuilder();
        int score = 0;
        sb.append(name + " you rolled ");
        for (int i = 0; i < rollScores.size(); i++) {
            sb.append(rollScores.indexOf(i) + " ");
            score = score + rollScores.indexOf(i);
        }
        System.out.println(sb.toString());
        int currentScore = players.get(turn).getPlayerScore();
        int total = currentScore + score;

    }

    public void printScore() {


    }

    private void generatePlayers(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            String name = CLI.getStr("\nWhat is your player name: ");
            Player newPlayer = new Player(name,0);
            newPlayer.setPlayerName(name);
        }
    }

    private ArrayList<Die> generateDie() {
        return null;

    }

    public static void displayPlayers(){
        for (int i = 0, count = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println("Current Players:");
            System.out.println((i + 1) + ") " + player.getPlayerName());
        }
    }

    public static void leaderBoard(){
        for (int i = 0, count = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println((i + 1) + ") " + player.getPlayerName() + " " + player.getPlayerScore());
        }
    }

    public static int options() {
        System.out.println("The round is over, how would you like to proceed.");
        System.out.println("(1) Next Round.\n(2) Display Leader Board");
        System.out.print("\nChoice: ");
        int choice = CLI.getNum(1, 2);
        return choice;
    }




}
