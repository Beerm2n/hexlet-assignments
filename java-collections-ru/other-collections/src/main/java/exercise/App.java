package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new TreeMap<>();
        for (String key : data1.keySet()) {
            if (data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else {
                result.put(key, "deleted");
            }
        }
        for (String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                result.put(key, "added");
            }
        }
        LinkedHashMap<String, String> result2 = new LinkedHashMap();
        for (String key : result.keySet()) {
            result2.put(key, result.get(key));
        }
        return result2;
    }

}
