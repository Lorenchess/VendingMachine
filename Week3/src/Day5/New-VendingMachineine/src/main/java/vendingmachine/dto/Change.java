package vendingmachine.dto;

import java.math.BigDecimal;

public class Change {
  private Coins coins;


    public Change(Coins coins) {
        this.coins = coins;
    }

    public Coins getCoins() {
        return coins;
    }

    public void getAmountOfChangeToUser(BigDecimal changeToUser) {

    }
}
