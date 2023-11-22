package calculator;

public enum Operations {
    SUBTRACTION, ADDITION, MULTIPLICATION, DIVISION, EXPONENTIATION;

    public static Operations fromString(String str) {
        if ("+".equals(str)) {
            return ADDITION;
        }
        if ("-".equals(str)) {
            return SUBTRACTION;
        }
        if ("*".equals(str)) {
            return MULTIPLICATION;
        }
        if ("/".equals(str)) {
            return DIVISION;
        }
        if ("^".equals(str)) {
            return EXPONENTIATION;
        }
        throw new IllegalStateException();
    }
}

