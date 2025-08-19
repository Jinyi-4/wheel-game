package item.consumables;

import item.Item;
import player.Player;

public class Consumable extends Item {
    ConsumableType consumableType;
    public int quantity;

    public Consumable(int id,ConsumableType consumableType, String name, int quantity) {
        this.id = id;
        this.consumableType = consumableType;
        this.name = name;
        this.quantity = 1;
    }


}
