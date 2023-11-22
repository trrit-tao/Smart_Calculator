import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        BigInteger number1 = new BigInteger(splitInput[0]);
        BigInteger number2 = new BigInteger(splitInput[1]);
        BigInteger number3 = new BigInteger(splitInput[2]);
        BigInteger number4 = new BigInteger(splitInput[3]);
        BigInteger result = number1.negate().multiply(number2);
        BigInteger result2 = result.add(number3);
        BigInteger result3 = result2.subtract(number4);
        System.out.println(result3);
    }
}