package itemRegistry;

import item.consumables.ConsumableType;

public class ConsumableTemplate extends ItemTemplate {
    ConsumableType consumableType;
    int valueCoins;
    public ConsumableTemplate(int id, String name, String type,ConsumableType consumableType, int valueCoins) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.consumableType = consumableType;
        this.valueCoins = valueCoins;
    }

}
