
import java.util.*;

public class Hashmap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hi");
        map.put(2, "Welcome");
        map.put(3, "Java");

        for (Map.Entry<Integer, String> e : map.entrySet())
            System.out.println(e.getKey() + " → " + e.getValue());
    }
}

//key value pairs ...keys should be unique