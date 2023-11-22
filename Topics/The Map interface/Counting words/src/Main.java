import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Arrays.stream;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

class MapUtils {

    public static Map<String, Integer> wordCount(String[] strings) {
       return stream(strings)
               .collect(groupingBy(e -> e))
               .entrySet()
               .stream()
               .collect(toMap(Map.Entry::getKey, e->e.getValue().size()));
    }

    public static void printMap(Map<String, Integer> map) {
        map.entrySet()
                .stream()
                .sorted(comparingByKey())
                .forEach(entrySet -> out.println(entrySet.getKey() + " : " + entrySet.getValue()));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}