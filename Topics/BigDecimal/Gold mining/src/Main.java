import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal bigDecimal = new BigDecimal(scanner.nextLine());
        BigDecimal bigDecimal2 = new BigDecimal(scanner.nextLine());
        BigDecimal bigDecimal3 = new BigDecimal(scanner.nextLine());
        System.out.println(bigDecimal.add(bigDecimal2.add(bigDecimal3)));
    }
}