import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number
        String regNumRegex = "[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}";
        boolean isRegex = regNum.matches(regNumRegex);
        System.out.println(isRegex);
    }
}