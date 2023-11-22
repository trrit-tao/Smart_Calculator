import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String[] array = input.split("");
        String input2 = scanner.nextLine().toLowerCase();
        String[] array2 = input2.split("");

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < array2.length; i++) {
            if (map2.containsKey(array2[i])) {
                map2.put(array2[i], map2.get(array2[i]) + 1);
            }else {
                map2.put(array2[i], 1);
            }
        }
        for (var entry : map.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                map2.put(entry.getKey(), map2.get(entry.getKey()) - entry.getValue());
            }else {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        for (var entry : map2.entrySet()) {
            if (entry.getValue() != 0) {
                result += Math.abs(entry.getValue());
            }
        }
        System.out.println(result);
    }
}