package locations;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class World {
    public String worldName;
    public String startLocation;
    private List<Location> locations; // Must match JSON key

    public static World loadWorld(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = World.class.getResourceAsStream(resourcePath)) {
            if (is == null) throw new IllegalStateException("Resource not found: " + resourcePath);
            return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), World.class);
        } catch (Exception e) {
            throw new RuntimeException("JSON Load Error: " + e.getMessage(), e);
        }
    }

    public Location findLocation(String name) {
        if (name == null || locations == null) return null;
        return locations.stream()
                .filter(l -> l.getName() != null && l.getName().equalsIgnoreCase(name.trim()))
                .findFirst()
                .orElse(null);
    }
}