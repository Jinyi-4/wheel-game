package wheel;

import item.Item;
import itemRegistry.ConsumableTemplate;
import itemRegistry.EquipmentTemplate;
import itemRegistry.ItemRegistry;
import itemRegistry.ItemTemplate;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wheel {
    private static volatile Wheel wheel;
    private Wheel(){};
    public static Wheel getWheel(){
        if(wheel ==null){
            synchronized (Wheel.class){
                if(wheel ==null){
                    wheel =new Wheel();
                }
            }
        }
        return wheel;
    }
    //todo:为什么这里是private 类型
    private final List<Prize> prizes = new ArrayList<Prize>();
    private Prize bigPrize;
    private ItemRegistry itemRegistry = ItemRegistry.getInstance();
    private final Random random = new Random();

    public void addPrize(int itemId, int amount){
        prizes.add(new Prize(itemId, amount));
    }

    public void addBigPrize(int itemId, int amount){
        bigPrize = new Prize(itemId,amount);
    }
    //开始转盘！抽奖逻辑
    public void spin(Player player){
        if(prizes.isEmpty()||bigPrize == null){
            System.out.println("奖池还没有准备好，耐心等待");
            return;
        }
        if(player.money < 10){
            System.out.println("金币不够哦，要不先去打工赚点钱～");
            return;
        }
        player.spinCount++;
        player.money -= 10;
        Prize prize ;

        if(player.spinCount % 50 == 0){
            prize = new Prize(bigPrize.itemId, bigPrize.quantity);
            System.out.println("获得服装" + itemRegistry.getTemplateById(prize.itemId).getName() );
        }else{
            if(player.spinCount % 10 == 0){
                List<Prize> equipPrizes = new ArrayList<>();
                for (Prize p : prizes) {
                    ItemTemplate t = itemRegistry.getTemplateById(p.itemId);
                    if (t instanceof EquipmentTemplate) {
                        equipPrizes.add(p);
                    }
                }
                prize = equipPrizes.get(random.nextInt(equipPrizes.size()));
                System.out.println("获得服装" + itemRegistry.getTemplateById(prize.itemId).getName() );
            }else{
                int r = random.nextInt(100);
                if(r < 20){
                    prize = new Prize(-1,5);
                }else if(r < 30){
                    prize = new Prize(-1,20);
                }else if(r < 80){
                    List<Prize> cList = new ArrayList<Prize>();
                    for(Prize p : prizes){
                        ItemTemplate t = itemRegistry.getTemplateById(p.itemId);
                        if(t instanceof ConsumableTemplate){
                            cList.add(p);
                        }
                    }
                    prize = cList.get(random.nextInt(cList.size()));
                    System.out.println("获得物品" + itemRegistry.getTemplateById(prize.itemId).getName() + "x" + prize.quantity);
                }else if(r < 95){
                    List<Prize> eList = new ArrayList<Prize>();
                    for(Prize p : prizes){
                        ItemTemplate t = itemRegistry.getTemplateById(p.itemId);
                        if(t instanceof EquipmentTemplate){
                            eList.add(p);
                        }
                    }
                    prize = eList.get(random.nextInt(eList.size()));
                    System.out.println("获得服装" + itemRegistry.getTemplateById(prize.itemId).getName() );

                }
                else {
                    prize =  new Prize(bigPrize.itemId, bigPrize.quantity);
                    System.out.println("太棒了！这个超级大奖是你的啦！ 获得服装：" + itemRegistry.getTemplateById(prize.itemId).getName() );
                }
            }
        }
        if(prize.itemId == -1){
            player.money += prize.quantity;
            System.out.println("获取金币："+ prize.quantity);
        }
        else{
            Item item = itemRegistry.createItemInstance(prize.itemId);
            player.receiveReward(item);
        }
    }
    //转盘可以获取奖品，比如衣服，比如消耗品，建模出现了问题
    static class Prize{
        int itemId;
        int quantity;
        public Prize(int itemId, int quantity){
            this.itemId = itemId;
            this.quantity = quantity;
        }
    }
}