import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
    private Map<T, Integer> map;

    public Bag() {
        this.map = new HashMap<>();
    }

    // Adding item to the bag
    public void add(T item) {
        map.put(item, map.getOrDefault(item, 0) + 1);
    }

    // Removes a single occurrence of an item from the bag
    // Will only be able to remove if it exists
    public void remove(T item) {
        if(map.containsKey(item)) {
            if(map.get(item) > 1) {
                map.put(item, map.get(item) - 1);
            } else {
                map.remove(item);
            }
        }
    }

    // Checking to see if an item is in the bag
    public boolean containsItem(T item) {
        return map.containsKey(item);
    }

    // Returning the amount of a single item within the bag
    public int count(T item) {
        return map.getOrDefault(item, 0);
    }

    // Returns the total number of elements inside the bag, including duplicates
    public int size() {
        int totalSize = 0;
        for(int count : map.values()) {
            totalSize += count;
        }

        return totalSize;
    }

    // Merges another bag into this bag
    public void merge(Bag<T> otherBag) {
        for(Map.Entry<T, Integer> entry : otherBag.map.entrySet()) {
            map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    // Returns a new bag that contains only the elements within the distinct bag
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for(T item : map.keySet()) {
            distinctBag.add(item);
        }

        return distinctBag;
    }

    // Returns the contents of the bag - in the form of a string
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<T, Integer> entry : map.entrySet()) {
            // Creating a format where each individual output is in parentheses
            builder.append(entry.getKey()).append(" (").append(entry.getValue()).append(")\n");
        }
        return builder.toString();
    }
}
