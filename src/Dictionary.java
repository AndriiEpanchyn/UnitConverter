import java.util.HashMap;

public class Dictionary {
    private String dicName;
    private HashMap<String, Double> volumes;

    public Dictionary() {
        this.dicName = "";
        this.volumes = new HashMap<>();
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public void setVolumes(HashMap<String, Double> volumes) {
        this.volumes = volumes;
    }

    public boolean add(String key, Double volume) {
        boolean answer = false;
        if (this.volumes.containsKey(key) == false) {
            this.volumes.put(key, volume);
            answer = true;
        }
        return answer;
    }

    public static Dictionary create() {
        Dictionary dictionary = new Dictionary();
        dictionary.setDicName("Lenghts");
        dictionary.add("Metr", 1.000);
        dictionary.add("inch", 0.0254);
        dictionary.add("ft", 0.3048);
        dictionary.add("chain", 20.117);
        dictionary.add("mile", 0.3048);

        return dictionary;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dicName='" + dicName + '\'' +
                ", volumes=" + volumes +
                '}';
    }

    public HashMap<String, Double> getVolumes() {
        return volumes;
    }
}
