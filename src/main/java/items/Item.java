package items;

import com.google.gson.annotations.SerializedName;

public class Item {
    public String name;
    public String type;

    @SerializedName("inStock")
    public boolean inStock = true;

    public String description;
    public String hint;

    public Integer damage; // for weapons

    public String pretty() {
        String dmg = (damage != null) ? (" dmg=" + damage) : "";
        return name + " [" + type + "]" + dmg;
    }
}
