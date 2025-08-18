package prize;
import player.Player;


//奖品的唯一作用就是让抽中的人获取
public interface Prize {
    void applyTo(Player p);   // 奖品作用到玩家

}
