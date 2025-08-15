package PrizeTypes;

import Player.Player;
import Prize.Prize;

public class GoldPrize implements Prize {
    private int amount;

    public GoldPrize(int amount) {
        this.amount = amount;
    }

    @Override
    public void applyTo(Player player) {
        player.addGold(amount);
    }
}
