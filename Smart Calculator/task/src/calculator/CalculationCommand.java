package calculator;

import java.math.BigInteger;

public interface CalculationCommand {
    String calculation(BigInteger result, BigInteger e);

    default String calculation(String e1, String e2){
        return calculation( new BigInteger(e1), new BigInteger(e2));
    }

}
