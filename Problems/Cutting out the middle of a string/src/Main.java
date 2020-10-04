import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();
        if (length % 2 == 1) {
            System.out.println(input.substring(0, length / 2) + input.substring(length / 2 + 1));
        } else {
            System.out.println(input.substring(0, length / 2 - 1) + input.substring(length / 2 + 1));
        }
    }
}