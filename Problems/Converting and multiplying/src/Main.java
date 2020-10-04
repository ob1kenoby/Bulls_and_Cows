import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new LinkedList<>();
        String temp = scanner.nextLine();
        while (!"0".equals(temp)) {
            try {
                result.add(String.valueOf(Integer.valueOf(temp) * 10));
            } catch (NumberFormatException e) {
                result.add("Invalid user input: " + temp);
            } finally {
                temp = scanner.nextLine();
            }
        }
        for (String number: result) {
            System.out.println(number);
        }
    }
}