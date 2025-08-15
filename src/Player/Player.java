package Player
public class Player {
    //金钱
    int money;
    //心情
    int mood;
    // 饱度
    int full;


    //这个初始化可以使用构造器设计模式
    void player(int money, int mood, int full) {
        this.money = money;
        this.mood = mood;
        this.full = full;
    }

    //一个是角色有什么衣服，一个是角色穿什么衣服
    //一个角色穿什么衣服
    //上衣和裙子互斥怎么实现？这个代码逻辑怎么处理

    //构造器模式？
    Outfit outfits;

    //仓库和槽位
    CharacterInventory inventory;

    //转盘
    public void spinWheel() {
//        Clothing prize = Wheel.getInstance().spin(); // 共享转盘
//        inventory.addItem(prize);
//        System.out.println(name + " 抽到了：" + prize.getName());

    }





}
