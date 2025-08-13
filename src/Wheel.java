
public class Wheel {
    private static volatile Wheel wheel;
    private Wheel(){};
    public static Wheel getTurntable(){
        if(wheel ==null){
            synchronized (Wheel.class){
                if(wheel ==null){
                    wheel =new Wheel();
                }
            }
        }
        return wheel;
    }
}