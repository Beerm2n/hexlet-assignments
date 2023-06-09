package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> userList) {
        return userList.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(user -> user.get("birthday")))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
