package Location;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class World {
    private List<Location> location;
    public String startLocation;

    public static World loadWorld(String resourcePath){
        Gson gson = new Gson();
        try (InputStream is = World.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalStateException("No source found: " + resourcePath);
            }
            return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), World.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed while loading: " + e.getMessage());
        }
    }

    public Location findLocation(String name){
        if(name == null){
            return null;
        }
        for (Location l: location){
            if (l.getName().equalsIgnoreCase(name.trim())){
                return l;
            }
        }
        return null;
    }

    public World(String startLocation) {
        this.startLocation = startLocation;
    }

    public Location getStartedLocation(){
        return findLocation(startLocation);
    }
}
