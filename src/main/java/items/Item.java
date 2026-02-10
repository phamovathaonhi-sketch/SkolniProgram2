package items;

import characters.Player;

public class Item {
    private String name;
    private boolean Instock;
    private Player player;
    private Item item;

    public Item(String name, boolean instock) {
        this.name = name;
        Instock = false;
    }

    public String getName() {
        player.getCurrentLocation().getItems(item);
        return name;
    }

    public boolean isInstock() {
       if (Instock == true ){
           System.out.println("Item avaible.");
       }
        return Instock;
    }
}
