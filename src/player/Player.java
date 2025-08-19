package player;

import inventory.*;
import item.Item;
import item.equipment.Equipment;

public class Player {
    //金钱
    String name;
    public int money ;
    //心情
    int mood = 100;
    // 饱度
    int full = 100;
    public int spinCount = 0;

    //这个初始化可以使用构造器设计模式
    public  Player(String name,int money) {
        this.name=name;
        this.money = money;
    }

    //一个是角色有什么衣服，一个是角色穿什么衣服
    //一个角色穿什么衣服
    //上衣和裙子互斥怎么实现？这个代码逻辑怎么处理

    //构造器模式？
    Equipment upper;
    Equipment bottom;
    Equipment dress;
    Equipment hat;
    Equipment shoe;

    //仓库和槽位
    public Inventory inventory = new Inventory();;

    //装备服装
    public boolean wearEquipment(Equipment e) {
        switch(e.equipType) {
            case UPPER:
                if(dress!=null){
                    dress = null;
                }
                upper = e;
                break;
            case BOTTOM:
                if(dress!=null){
                    dress = null;
                }
                bottom = e;
                break;
            case DRESS:
                if(upper!=null||bottom!=null){
                    upper = null;
                    bottom = null;
                }
                dress = e;
                break;
            case HAT:
                hat = e;
            case SHOE:
                shoe = e;
        }
        System.out.println("穿戴装备成功：" + e.name);
        return true;
    }
    //转动转盘
    int n = 0;
    public void receiveReward(Item item) {
        inventory.addItem(item, this);
    }


    public void addGold(int amount) {
        money += amount;
    }
}
