package itemRegistry;
public abstract class ItemTemplate {
    public int id;
    public String name;
    String type; // "EQUIP" 或 "CONSUMABLE"

    public String getName() {
        return name;
    }
}


