package locations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class World {
    public String worldName;
    public String startLocation;

    @SerializedName("Instroduction")
    public String introduction;

    public List<Location> locations;

    /**
     * World loader. Load from json
     * @param resourcePath
     * @return
     */
    public static World loadWorld(String resourcePath) {
        Gson gson = new GsonBuilder().create();
        try (InputStream is = World.class.getResourceAsStream(resourcePath)) {
            if (is == null) throw new IllegalStateException("Resource not found: " + resourcePath);
            return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), World.class);
        } catch (Exception e) {
            throw new RuntimeException("JSON Load Error: " + e.getMessage(), e);
        }
    }

    /**
     * search for location
     * @param name
     * @return
     */

    public Location findLocation(String name) {
        if (name == null || locations == null) return null;
        return locations.stream()
                .filter(l -> l != null && l.name != null && l.name.equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
    }
}
