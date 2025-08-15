package Wheel;
public class Wheel {
    private static volatile Wheel wheel;
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