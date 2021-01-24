package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayerBettingTest {

    @Test
    public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
        Player player = createPlayerWithBalance(20);
        player.bets(10);
        player.wins();
        assertThat(player.balance())
                .isEqualTo(30);
    }

    @Test
    public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
        Player player = createPlayerWithBalance(80);
        player.bets(70);
        player.ties();
        assertThat(player.balance())
                .isEqualTo(80);
    }

    @Test
    public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
        Player player = createPlayerWithBalance(35);
        player.bets(30);
        player.loses();
        assertThat(player.balance())
                .isEqualTo(5);
    }

    @Test
    public void playerWith40Bets15BalanceIs25() throws Exception {
        Player player = createPlayerWithBalance(40);
        player.bets(15);
        assertThat(player.balance())
                .isEqualTo(25);
    }

    @Test
    public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
        Player player = createPlayerWithBalance(18);
        assertThat(player.balance())
                .isEqualTo(18);
    }

    @Test
    public void playerWith30Bets15Bets20TotalAmountBet35() throws Exception {
        Player player = createPlayerWithBalance(30);
        player.bets(15);
        player.wins();
        player.bets(20);
        player.loses();
        assertThat(player.totalAmountBet()).isEqualTo(35);
    }

    @Test
    public void playerWith300Bets15Bets20Bets100TotalAmountBet135() throws Exception {
        Player player = createPlayerWithBalance(300);
        player.bets(15);
        player.wins();
        player.bets(20);
        player.loses();
        player.bets(100);
        player.loses();
        assertThat(player.totalAmountBet()).isEqualTo(135);
    }

    private Player createPlayerWithBalance(int amount) {
        Player player = new Player();
        player.deposits(amount);
        return player;
    }
}
