package calculator.action;

import calculator.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static calculator.Operations.*;
import static java.lang.Character.isDigit;

public class CalculatorAction implements Action {
    private final Map<Operations, CalculationCommand> map = new HashMap<>();

    private final VariablesContains instance = VariablesContains.getInstance();

    public CalculatorAction() {
        map.put(SUBTRACTION, new Subtraction());
        map.put(ADDITION, new Addition());
        map.put(MULTIPLICATION, new Multiplication());
        map.put(DIVISION, new Division());
        map.put(EXPONENTIATION, new Exponentiation());
    }

    @Override
    public void action(String input) {
        String str = instance.replaysVariables(input).replaceAll("\\s", "")
                .replaceAll("-{3}", "-")
                .replaceAll("-{2}", "+")
                .replaceAll("(\\+-)|(-\\+)", "-")
                .replaceAll("\\++", "+");

        if (!str.matches("[\\d\\+\\-\\*/\\(\\)\\^\\s]+|\\+$|\\-$|\\*$|\\/$")
                || str.matches(".*\\*{2,}.*|.*\\/{2,}.*|.*\\^{2,}.*")) {

            throw new RuntimeException("Invalid expression");
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                for (;  i < str.length() && isDigit(str.charAt(i)); i++) {
                    builder.append(str.charAt(i));
                }
                i--;
            } else {
                builder.append(str.charAt(i));
            }
            builder.append(" ");
        }
        str = builder.toString();
        String[] replaceInput = str.replaceAll("\\s+", " ")
                .split(" ");
        calculate(toPostfix(replaceInput));

    }

    public void calculate(Deque<String> stack) {
        var stackResult = new ArrayDeque<String>();
        while (!stack.isEmpty()) {
            String elementStack = stack.pollFirst();
            if (elementStack.matches("\\d+")) {
                stackResult.add(elementStack);
            } else {
                String e2 = (stackResult.pollLast());
                String e1 = (stackResult.pollLast());

                stackResult.add(map.get(fromString(elementStack)).calculation(e1, e2));
            }
        }
        System.out.println(stackResult.pollLast());
    }

    public Deque<String> toPostfix(String[] input) {
        var stackResult = new ArrayDeque<String>();
        var postfix = new ArrayDeque<String>();
        for (String e : input) {
            if (e.matches("\\d+")) {
                stackResult.add(e);
            } else if (e.equals("(")) {
                postfix.add(e);
            } else if (e.equals(")")) {
                String w = "";
                while (!postfix.isEmpty() && !(w = postfix.pollLast()).equals("(")) {

                    stackResult.add(w);
                }
                if (!w.equals("(")) {
                    throw new RuntimeException("Invalid expression");
                }
            } else {
                while (!postfix.isEmpty() && pidr(postfix.peekLast(), e)) {
                    stackResult.add(postfix.pollLast());
                }
                postfix.add(e);
            }
        }
        for (int i = 0; i < postfix.size(); ) {
            String st = postfix.pollLast();
            if (st.equals("(")) {
                throw new RuntimeException("Invalid expression");
            }
            stackResult.add(st);

        }
        return stackResult;
    }

    public boolean pidr(String fromStack, String fromString) {
        switch (fromStack) {
            case "^":
                return true;
            case "*":
            case "/":
                return !fromString.equals("^");
            case "+":
            case "-":
                return !fromString.equals("*") && !fromString.equals("/") && !fromString.equals("^");
            default:
                return false;
        }
    }


//        String[] replaceInput = str.replaceAll("\\s+", " ")
//                .replaceAll("-{3}", "-")
//                .replaceAll("-{2}", "+")
//                .replaceAll("\\++", "+")
//                .split(" ");
//        int result = Integer.parseInt(replaceInput[0]);
//        for (int i = 1; i < replaceInput.length; i += 2) {
//            result = map.get(fromGGGG(replaceInput[i]))
//                    .calculation(result, replaceInput[i + 1]);
//        }
//
//        System.out.println(result);
}
