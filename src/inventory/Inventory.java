package inventory;

import item.Item;
import item.consumables.Consumable;
import item.equipment.Equipment;
import player.Player;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Map<Integer,Equipment> equipments = new HashMap<>();
    public Map<Integer,Consumable> consumables = new HashMap<>();

    public void addItem(Item item, Player player) {
        if(item instanceof Equipment e) {
            if(equipments.containsKey(e.id)) {
                System.out.println("该服装已经存在，将换成金币～");
                player.money += e.getValueCoins();
            }else{
                System.out.println("获取一件新服装！快点换上它看看吧！");
                equipments.put(e.id, e);
            }
        }else if(item instanceof Consumable c) {
            consumables.merge(c.id, c,(OldC,newC)->{
                OldC.quantity += newC.quantity;
                return OldC;
            });
            System.out.println("获得"+c.name+"x"+c.quantity+"~");
        }
    }
}
