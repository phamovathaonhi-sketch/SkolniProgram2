package items;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> items = new ArrayList<>();
    private final int maxSize;

    public Bag(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean add(Item item) {
        if (item == null) return false;
        if (items.size() >= maxSize) return false;
        items.add(item);
        return true;
    }

    public boolean has(String name) { return get(name) != null; }

    public Item get(String name) {
        return items.stream()
                .filter(i -> i.name != null && i.name.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public boolean remove(String name) {
        Item it = get(name);
        if (it == null) return false;
        return items.remove(it);
    }

    public List<Item> all() { return List.copyOf(items); }
}
