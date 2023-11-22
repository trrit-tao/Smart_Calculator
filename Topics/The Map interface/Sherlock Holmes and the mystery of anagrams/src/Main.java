import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOneAnagrams = scanner.nextLine().toUpperCase(Locale.ROOT);
        String inputTwoAnagrams = scanner.nextLine().toUpperCase(Locale.ROOT);
        var map = new HashMap<Character,Integer>();
            for (int i = 0; i < inputOneAnagrams.length(); i ++) {
                char key = inputOneAnagrams.charAt(i);
            map.put(key,map.getOrDefault(key,0) + 1);
        }
            var map2 = new HashMap<Character,Integer>();
        for (int i = 0; i < inputTwoAnagrams.length(); i ++) {
            char key2 = inputTwoAnagrams.charAt(i);
            map2.put(key2,map2.getOrDefault(key2,0) + 1);
        }
        if (map.equals(map2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
