package item.consumables;

import player.Player;

public class Food extends Consumable {
    int mood;
    int full;

    public Food(int mood, int full) {
        this.mood = mood;
        this.full = full;
    }

    public int getMood() {
        return mood;
    }

    public int getFull() {
        return full;
    }

    @Override
    public void use(Player player) {

    }
}
