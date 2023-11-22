import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        String dateRegex = "(19|20)[0-9][0-9]";
        String dateRegex2 = "(3[0-1]|2\\d|1\\d)";
        String dateRegex3 = "(0[1-9]|1[0-2])";
        String spase = "(-|/|\\.)";
        String result1 = "(19|20)[0-9][0-9](-|/|\\.)(0[1-9]|1[0-2])(-|/|\\.)(3[0-1]|2\\d|1\\d)";
        String result2 = "(3[0-1]|2\\d|1\\d)(-|/|\\.)(0[1-9]|1[0-2])(-|/|\\.)(19|20)[0-9][0-9]";
        if (date.matches(result1) || date.matches(result2)) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}