package itemRegistry;

import item.*;
import item.consumables.Consumable;
import item.equipment.Equipment;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    //todo: 这里的instance的逻辑是什么？
    private static final ItemRegistry INSTANCE = new ItemRegistry();
    private final Map<Integer, ItemTemplate> templates = new HashMap<>();

    private ItemRegistry() {}
    public static ItemRegistry getInstance() {
        return INSTANCE;
    }
    public void registerTemplate(ItemTemplate template) {
        templates.put(template.id, template);
    }
    public ItemTemplate getTemplateById(int id) {
        return templates.get(id);
    }

    public Item createItemInstance(int id) {
        ItemTemplate template = getTemplateById(id);
        switch (template) {
            case null -> {
                return null;
            }
            case EquipmentTemplate equipmentTemplate -> {
                EquipmentTemplate eqTemp = (EquipmentTemplate) template;
                return new Equipment(eqTemp.id, eqTemp.equipType, eqTemp.name, eqTemp.valueCoins);
            }
            case ConsumableTemplate consumableTemplate -> {
                ConsumableTemplate cTemp = (ConsumableTemplate) template;
                return new Consumable(cTemp.id, cTemp.consumableType, cTemp.name, cTemp.valueCoins);
            }
            default -> {
            }
        }
        return null;
    }
}
