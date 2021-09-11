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
        System.out.println("\nGreat All players have been set. Here are the players");
        playRound();
    }

    private void generatePlayers(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            String name = CLI.getStr("What is your player name: ");
            Player newPlayer = new Player(name,0);
            newPlayer.playersDice = generateDie();
            players.add(newPlayer);
        }
    }

    private ArrayList<Die> generateDie() {
        return null;

    }

    public void playRound() {

        if (currentRound > numOfRounds){
            System.out.println("Game has Ended.");
            Menu.proceed();
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println("Current Round: " + currentRound);
            playerTurn(i);
        }
        System.out.println("\nRound is over. Here are the current scores:\n ");
        leaderBoard();
        currentRound++;
        currentTurn = 0;
        options();
    }

    public void playerTurn(int turn ) {

        String name = players.get(turn).getPlayerName();
        System.out.println("\n" + name + " it is your turn to roll.\nPress Enter to roll");
        CLI.proceed();
        ArrayList<Integer> rollScores = new ArrayList<Integer>();
        Die die = new Die();
        rollScores = die.rollDie(numOfDice);

        StringBuilder sb = new StringBuilder();
        int score = 0;
        sb.append("\n" + name + " you rolled ");
        for (int i = 0; i < rollScores.size(); i++) {
            sb.append(rollScores.get(i) + " ");
            score = score + rollScores.get(i);
        }
        System.out.println(sb.toString());
        int currentScore = players.get(turn).getPlayerScore();
        int total = currentScore + score;
        players.get(turn).setPlayerScore(total);

    }

    public void options() {
        System.out.println("\nThe round is over, how would you like to proceed.");
        System.out.println("(1) Next Round.\n(2) Display Leader Board");
        System.out.print("\nChoice: ");
        int choice = CLI.getNum(1, 2);

        if (choice == 1){
            playRound();
        }else if (choice == 2){
            leaderBoard();
        }
        options();
    }

    public static void displayPlayers(){
        System.out.println("\nCurrent Players:");
        for (int i = 0, count = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println((i + 1) + ") " + player.getPlayerName());
        }
    }

    public static void leaderBoard(){
        System.out.println("\nCurrent Players and scores:");
        for (int i = 0, count = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println((i + 1) + ") " + player.getPlayerName() + " has " + player.getPlayerScore() + " points.");
        }
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }




}
