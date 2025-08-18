package wheel;
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

    //转盘可以获取奖品，比如衣服，比如消耗品，建模出现了问题
    public spin{

    }
}