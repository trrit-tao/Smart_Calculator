import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var inputOneAnagrams = scanner.nextLine().split(" ");
        var map = new HashMap<String, Integer>();

        for (var key : inputOneAnagrams) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (var key : scanner.nextLine().split(" ")) {
            map.put(key, map.getOrDefault(key, 0) - 1);
        }

        for (var value : map.values()) {
            if (value < 0) {
                System.out.println("You are busted");
                return;
            }

        }
        System.out.println("You get money");
    }
}
