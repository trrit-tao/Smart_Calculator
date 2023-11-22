import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BigInteger num = new BigInteger(input);
        BigInteger result = BigInteger.ONE;
        int count = 2;
        while (result.compareTo(num) < 0) {
            result = result.multiply(BigInteger.valueOf(count));
            count += 1;
        }
        System.out.println(count - 1);
    }
}