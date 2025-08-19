package itemRegistry;

import item.equipment.EquipType;
//todo：比较困惑的是模版和对象的区别，以及数量的逻辑没有放在仓库里，而是放在了装备和药品对象里
public class EquipmentTemplate extends ItemTemplate {
    public EquipType equipType;
    public int valueCoins;
    public EquipmentTemplate(){};
    public EquipmentTemplate(int id, String name, String type, EquipType equipType,int valueCoins) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.equipType = equipType;
        this.valueCoins = valueCoins;
    }
}
