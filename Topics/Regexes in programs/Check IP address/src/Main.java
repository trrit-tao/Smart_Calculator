import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input = scanner.nextLine();
        String r = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        int result = 0;
        if (!input.matches(r)) {
            System.out.println("NO");
        }else {
            String[] array = input.split("\\.");
            for (int i = 0; i < array.length; i++) {
                if (Integer.parseInt(array[i]) >= 0 && Integer.parseInt(array[i]) <= 255) {
                    result++;
                }
            }
            if (result == 4) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}