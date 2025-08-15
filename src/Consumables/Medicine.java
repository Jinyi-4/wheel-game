package Consumables;

import Player.Player;

public class Medicine extends Consumables{

    int health;

    public Medicine(int health, String name, int value) {

    //    this.health = health;
    //    this.name = name;
        this.value = value;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void use(Player player) {

    }
}
