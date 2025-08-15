package ClothesType;

//不会实例化的抽象方法
//代码逻辑不对啊
public abstract class Clothes implements Prize{
    //上衣，下装，连衣裙，
    String name;
    int pay;
    int charm;

    public Clothes(String name, int pay, int charm) {
        this.name = name;
        this.pay = pay;
        this.charm = charm;
    }
    public int getCost() {
        return pay;
    }

    public int getValue() {
        return charm;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void applyTo(Player player) {

    }
}


