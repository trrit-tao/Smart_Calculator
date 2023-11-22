package calculator;

import java.math.BigInteger;

public class Exponentiation implements CalculationCommand {

    @Override
    public String calculation(BigInteger result, BigInteger e) {
        return result.pow(e.intValue()).toString();
    }
}
