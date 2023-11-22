import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> deq = new ArrayDeque<>();
        scanner.nextLine();
        while (scanner.hasNext()) {
            deq.addFirst(scanner.next());
        }
            deq.forEach(System.out::println);
    }
}