package calculator.action;

import calculator.action.Action;

public class ExitCalculator implements Action {

    @Override
    public void action(String str) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
