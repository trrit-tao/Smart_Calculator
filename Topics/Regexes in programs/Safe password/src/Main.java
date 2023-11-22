import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regs1 = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{12,}";
        if (input.matches(regs1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}