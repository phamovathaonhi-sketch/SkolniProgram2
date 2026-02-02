package items;

public class Item {
    private String name;
    private boolean Instock;

    public Item(String name, boolean instock) {
        this.name = name;
        Instock = instock;
    }

    public String getName() {
        return name;
    }

    public boolean isInstock() {
        return Instock;
    }
}
