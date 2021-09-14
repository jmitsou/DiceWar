package com.company;

import java.util.ArrayList;

public class Player {

    public ArrayList<Die> playersDice;

    private String playerName;
    private int playerScore;
    private int winner;

    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }




}
