package item.equipment;

import item.Item;
import player.Player;



public class Equipment extends Item{
    //上衣，下装，连衣裙，
    public EquipType equipType;
    int valueCoins;

//    int pay;
//    int charm;

    public Equipment(int id,EquipType equipType,String name, int valueCoins) {
        this.id=id;
        this.name = name;
        this.equipType = equipType;
        this.valueCoins = valueCoins;
//        this.pay = pay;
//        this.charm = charm;
    }

    public Equipment() {

    }

    public int getValueCoins(){
        return valueCoins;
    }

}


