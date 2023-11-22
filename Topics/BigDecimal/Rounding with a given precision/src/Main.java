import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal bigDecimal = new BigDecimal(scanner.nextLine());
        int newScale = scanner.nextInt();
        System.out.println(bigDecimal.setScale(newScale, RoundingMode.HALF_DOWN));
    }   
}