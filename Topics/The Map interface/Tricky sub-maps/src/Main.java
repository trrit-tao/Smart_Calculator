import java.util.*;

import static java.util.Map.Entry.comparingByKey;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        Map<Integer, String> result = new LinkedHashMap<>();
        var firstKey = map.firstKey();
        var lastKey = map.lastKey();
        if (firstKey % 2 != 0) {
            map.entrySet().stream()
                    .limit(5)
                    .sorted(comparingByKey(Comparator.reverseOrder()))
                    .forEach(e -> {
                        if (e.getKey() <= firstKey + 4) {
                            result.put(e.getKey(), e.getValue());
                        }
                    });

        } else {
            map.entrySet().stream()
                    .sorted(comparingByKey(Comparator.reverseOrder()))
                    .limit(5)
                    .forEach(e -> {
                        if (e.getKey() <= lastKey && e.getKey() >= lastKey - 4) {
                            result.put(e.getKey(), e.getValue());
                        }
                    });

        }
        return result;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}