import java.math.BigInteger;
import java.util.Scanner;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int input) {
        if (input == 0) {
            return BigInteger.ONE;
        }
        BigInteger num =  new BigInteger(String.valueOf(input));
        BigInteger result =  new BigInteger(String.valueOf(input));
        for (int i = 0; i < input - 2; i = i + 2) {
            result = result.multiply(num = num.subtract(BigInteger.TWO));
        }
    return result;
    }
}
