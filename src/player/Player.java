package player;

import inventory.*;
import item.equipment.Equipment;

public class Player {
    //金钱
    String name;
    public int money;
    //心情
    int mood;
    // 饱度
    int full;


    //这个初始化可以使用构造器设计模式
    void player(String name,int money, int mood, int full) {
        this.name=name;
        this.money = money;
        this.mood = mood;
        this.full = full;
    }

    //一个是角色有什么衣服，一个是角色穿什么衣服
    //一个角色穿什么衣服
    //上衣和裙子互斥怎么实现？这个代码逻辑怎么处理

    //构造器模式？
    Equipment upper;
    Equipment pants;
    Equipment dress;
    Equipment hat;
    Equipment shoes;

    //仓库和槽位
    Inventory inventory;

    //装备服装
    public boolean wearEquipment(Equipment e) {
        if (e.equipType.equals("连衣裙") && upper ) {
            System.out.println("连衣裙与上衣/裤子冲突");
            return false;
        }
        if ((e.equipType.equals("上衣") || e.equipType.equals("裤子")) &&
                wornEquipments.containsKey("连衣裙")) {
            System.out.println("上衣/裤子与连衣裙冲突");
            return false;
        }
        wornEquipments.put(e.equipType, e);
        System.out.println("穿戴装备成功：" + e.name);
        return true;
    }
    //转动转盘
    int n = 0;
    public void spinWheel() {

    }


    public void addGold(int amount) {
        money += amount;
    }
}
