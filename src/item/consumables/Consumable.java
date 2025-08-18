package item.consumables;

import item.Item;
import player.Player;
import prize.Prize;

public class Consumable extends Item implements Prize {
    ConsumableType consumableType;
    public int quantity;

    public Consumable(int id,ConsumableType consumableType, String name, int quantity) {
        this.id = id;
        this.consumableType = consumableType;
        this.name = name;
        this.quantity = 1;
    }

    @Override
    public void applyTo(Player player){
        //把消耗品加到仓库里
        //todo:
    }


}
