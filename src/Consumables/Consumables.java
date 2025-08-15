package Consumables;

import Player.Player;
import Prize.Prize;

public abstract class Consumables implements Prize {
    String name;
    int value;

    public void sale(Player player) { //售卖消耗品
       //todo: 售卖价格
    }

    public String getName() {
        return name;
    }

    @Override
    public void applyTo(Player player){
        //把消耗品加到仓库里
        //todo:
    }

    public abstract void use(Player player);
}
