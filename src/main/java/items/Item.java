package items;

import com.google.gson.annotations.SerializedName;

public class Item {
    public String name;
    public String type;

    @SerializedName("inStock")
    public boolean inStock = true;

    public String description;
    public Integer damage;

    // for blood samples
    public Integer ageHours;

    public boolean isFreshBlood() {
        if (!"BloodSample".equalsIgnoreCase(type)) return true;
        if (ageHours == null) return true;
        return ageHours <= 24;
    }

    public String pretty() {
        String dmg = (damage != null) ? (" dmg=" + damage) : "";
        String age = (ageHours != null) ? (" ageHours=" + ageHours) : "";
        return name + " [" + type + "]" + dmg + age;
    }
}
