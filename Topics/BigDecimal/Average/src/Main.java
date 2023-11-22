import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal bigDecimal = new BigDecimal(scanner.nextLine());
        BigDecimal bigDecimal2 = new BigDecimal(scanner.nextLine());
        BigDecimal bigDecimal3 = new BigDecimal(scanner.nextLine());
        BigDecimal bigDecimal4 = bigDecimal.add(bigDecimal2.add(bigDecimal3));
        System.out.println(bigDecimal4.divide(new BigDecimal("3"),0,RoundingMode.HALF_EVEN));
    }
}