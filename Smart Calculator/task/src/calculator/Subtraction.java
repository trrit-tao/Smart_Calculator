package calculator;

import java.math.BigInteger;

public class Subtraction implements CalculationCommand {

    @Override
    public String calculation(BigInteger result, BigInteger e) {
        return result.subtract(e).toString();
    }
}
