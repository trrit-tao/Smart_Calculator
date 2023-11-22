package calculator;


import calculator.action.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    static Map<String, Action> commands = new HashMap<>();
    static Map<String, Action> actions = new HashMap<>();

    static {
        commands.put("/exit", new ExitCalculator());
        commands.put("/help", new HelpCalculator());
        commands.put("NO_COMMAND", (e) -> System.out.println("Unknown command"));
        actions.put("", a -> {});
        actions.put("calculator", new CalculatorAction());
        actions.put("add_variable", VariablesContains.getInstance());
    }


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {

                var input = scanner.nextLine().trim();
                if (input.startsWith("/")) {
                    commands.getOrDefault(input, commands.get("NO_COMMAND")).action(input);
                } else if (input.contains("=") || input.matches("[a-zA-Z]+")) {
                    actions.get("add_variable").action(input);
                } else {
                    actions.getOrDefault(input, actions.get("calculator")).action(input);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
