package com.jitterted.ebp.blackjack;

public class Player {

    private int balance = 0;
    private int bet = 0;
    private int totalBetAmount = 0;

    public void deposits(int amount) {
        balance += amount;
    }

    public void bets(int betAmount) {
        updateAttributes(betAmount);
        addBonus(betAmount);
    }

    private void addBonus(int betAmount) {
        if (betAmount >= 100)
            balance += 10;
    }

    private void updateAttributes(int betAmount) {
        bet = betAmount;
        balance -= betAmount;
        totalBetAmount += betAmount;
    }

    public int balance() {
        return balance;
    }

    public void wins() {
        balance += bet * 2;
    }

    public void loses() {
        balance += bet * 0;
    }

    public void ties() {
        balance += bet * 1;
    }

    public int totalAmountBet() {
        return totalBetAmount;
    }
}
