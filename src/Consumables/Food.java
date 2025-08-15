package Consumables;

import Player.Player;

public class Food extends Consumables{
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
