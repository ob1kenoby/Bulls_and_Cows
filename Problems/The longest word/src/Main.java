import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String longest = "";
        for (String word: input) {
            longest = word.length() > longest.length() ? word : longest;
        }
        System.out.println(longest);
    }
}