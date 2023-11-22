import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        var stack = new ArrayDeque<String>();
        var result = new ArrayDeque<>();

        while (!input.isEmpty()) {
            if (input.charAt(1) == '/') {
                var closingTag = input.substring(0, input.indexOf('>') + 1);
                var rawTag = closingTag.replace("/", "");
                input = input.substring(closingTag.length());
                var body = "";
                var openTag = "";
                while (!(openTag = stack.pollLast()).equals(rawTag)) {
                    body = openTag + body;
                }
                stack.add(openTag + body + closingTag);
                result.add(body);
            } else if (input.startsWith("<")) {
                String openTag = input.substring(0, input.indexOf('>') + 1);
                input = input.substring(openTag.length());
                stack.add(openTag);
            } else {
                String openTag = input.substring(0, input.indexOf('<'));
                input = input.substring(openTag.length());
                stack.add(openTag);
            }
        }
        result.forEach(System.out::println);
    }
}