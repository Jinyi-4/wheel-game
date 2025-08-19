package wheelGameDemo;

import item.equipment.EquipType;
import itemRegistry.ConsumableTemplate;
import itemRegistry.EquipmentTemplate;
import itemRegistry.ItemRegistry;
import player.Player;
import wheel.Wheel;

public class WheelGameDemo {
    public static <PrizePool> void main(String[] args) {
        ItemRegistry registry = ItemRegistry.getInstance();
        //注册装备
        EquipmentTemplate e1 = new EquipmentTemplate(); e1.id=101; e1.name="红色T恤"; e1.equipType= EquipType.UPPER; e1.valueCoins=100;
        EquipmentTemplate e2 = new EquipmentTemplate(); e2.id=102; e2.name="蓝色衬衫"; e2.equipType=EquipType.UPPER; e2.valueCoins=120;
        EquipmentTemplate e3 = new EquipmentTemplate(); e3.id=201; e3.name="牛仔裤"; e3.equipType=EquipType.BOTTOM; e3.valueCoins=80;
        EquipmentTemplate e4 = new EquipmentTemplate(); e4.id=301; e4.name="连衣裙"; e4.equipType=EquipType.DRESS; e4.valueCoins=200;
        EquipmentTemplate e5 = new EquipmentTemplate(); e4.id=302; e4.name="天鹅羽绒礼服"; e4.equipType=EquipType.DRESS; e4.valueCoins=400;
        registry.registerTemplate(e1); registry.registerTemplate(e2); registry.registerTemplate(e3); registry.registerTemplate(e4);

        // 注册消耗品
        ConsumableTemplate c1 = new ConsumableTemplate(); c1.id=401; c1.name="黑森林慕斯蛋糕"; registry.registerTemplate(c1);
        ConsumableTemplate c2 = new ConsumableTemplate(); c2.id=402; c2.name="气泡山茶奶茶"; registry.registerTemplate(c2);
        ConsumableTemplate c3 = new ConsumableTemplate(); c1.id=403; c1.name="岩浆乳酪牛角包"; registry.registerTemplate(c3);
        ConsumableTemplate c4 = new ConsumableTemplate(); c2.id=404; c2.name="板蓝根"; registry.registerTemplate(c4);
        ConsumableTemplate c5 = new ConsumableTemplate(); c1.id=405; c1.name="红糖水"; registry.registerTemplate(c5);
        ConsumableTemplate c6 = new ConsumableTemplate(); c2.id=406; c2.name="布洛芬"; registry.registerTemplate(c6);

        // 配置奖池
        Wheel pool = Wheel.getWheel();
        pool.addPrize(101,1); // 装备
        pool.addPrize(102,1); // 装备
        pool.addPrize(201,1); // 装备
        pool.addPrize(301,1); // 装备
        pool.addPrize(401,1); // 消耗品
        pool.addPrize(402,1); // 消耗品
        pool.addPrize(403,1); // 消耗品
        pool.addPrize(404,2); // 消耗品
        pool.addPrize(405,3); // 消耗品
        pool.addPrize(406,1); // 消耗品
        pool.addBigPrize(302,1);

        // 创建玩家
        Player player = new Player("daisy小鸟", 1000);

        // 模拟10次转盘
        for(int i=1;i<=50;i++) {
            System.out.println("\n--- 第"+i+"次转盘 ---");
            pool.spin(player);
        }

        System.out.println("\n玩家最终金币：" + player.money);
        System.out.println("玩家仓库装备：" + player.inventory.equipments.values());
        System.out.println("玩家仓库消耗品：" + player.inventory.consumables.entrySet());
    }
}
