package calculator.action;

import java.util.HashMap;
import java.util.Map;

public class VariablesContains implements Action {
    private static VariablesContains instance;
    Map<String, String> variablesMap = new HashMap<>();

    public static VariablesContains getInstance() {
        if (instance == null) {
            instance = new VariablesContains();
        }
        return instance;
    }

    public String replaysVariables(String str) {
        var result = str;
        for (var entry : variablesMap.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue().toString());
        }
        return result;
    }

    @Override
    public void action(String str) {
        str = str.trim().replaceAll("\\s+", "");
        if (variablesMap.containsKey(str)) {
            System.out.println(variablesMap.get(str));
            return;
        }
        if (!str.contains("=")) {
            throw new RuntimeException("Unknown variable");
        }
        String[] splitStr = str.split("=");
        if (!splitStr[0].matches("[a-zA-Z]+")
                || !splitStr[1].matches("\\-?(\\d+|[a-zA-Z]+)")) {
            throw new RuntimeException("Invalid identifier");
        }

        if (splitStr[1].matches("[a-zA-Z]+")
                && !variablesMap.containsKey(splitStr[1])) {
            throw new RuntimeException("Unknown variable");
        }
        if (variablesMap.containsKey(splitStr[1])) {
            variablesMap.put(splitStr[0], variablesMap.get(splitStr[1]));
        }else {
            variablesMap.put(splitStr[0], splitStr[1]);
        }
    }
}


