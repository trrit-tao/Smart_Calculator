import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt()-1;
        int to = scanner.nextInt();
        int countСycle = scanner.nextInt();
        var map = new TreeMap<>();
        for (int i = 0; i < countСycle; i++) {
            map.put(scanner.nextInt(),scanner.next());
        }
        map.entrySet().stream()
                .skip(from)
                .limit(to-from)
                .forEach((entry)-> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}