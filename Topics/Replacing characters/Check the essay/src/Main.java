import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class CheckTheEssay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern patternFrance = Pattern.compile("Franse");
        Matcher matcherFrance = patternFrance.matcher(text);
        String text1 = matcherFrance.replaceAll("France");

        Pattern patternTower = Pattern.compile("Eifel tower");
        Matcher matcherTower = patternTower.matcher(text1);
        String text2 = matcherTower.replaceAll("Eiffel Tower");

        Pattern patternXIX = Pattern.compile("19th");
        Matcher matcherXIX = patternXIX.matcher(text2);
        String text3 = matcherXIX.replaceAll("XIXth");

        Pattern patternXX = Pattern.compile("20th");
        Matcher matcherXX = patternXX.matcher(text3);
        String text4 = matcherXX.replaceAll("XXth");

        Pattern patternXXI = Pattern.compile("21st");
        Matcher matcherXXI = patternXXI.matcher(text4);
        System.out.println(matcherXXI.replaceAll("XXIst"));
    }
}